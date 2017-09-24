import com.opencsv.CSVWriter;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static String myUrl = "https://bt.rozetka.com.ua/ua/coffee_machines/c80164/filter/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Main.parseCategory(Main.myUrl);
    }

    public static void writeCSV(String fileName, List<String[]> content) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(fileName), ',');
            for (String[] entry : content) {
                writer.writeNext(entry);
            }
            // No print printf("%s file saved\n", fileName);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static JSONArray getPageJSON(Element doc) {
        Elements scripts = doc.select("script");
        JSONObject scriptInfo = null;
        JSONArray scriptInfoArray = new JSONArray();
        for (Element sc : scripts) {
            if (sc.html().startsWith("dataLayer.push(")) {
                String scriptInfoStr = sc.html().substring(15, sc.html().indexOf(");"));

                try {
                    scriptInfo = new JSONObject(scriptInfoStr);
                    scriptInfoArray = scriptInfo.getJSONArray("products");
                } catch (JSONException e) {
                    e.printStackTrace();
                    return scriptInfoArray;
                }

            }
        }
        return scriptInfoArray;
    }


    public static void parseCategory(String url) {
        File dataFolder = new File("./data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Elements numPagesElements = doc.select("a.paginator-catalog-l-link");
        Integer numPages = 0;
        if (numPagesElements.size() > 0) {
            numPages = Integer.parseInt(numPagesElements.last().text());
        }
        printf("%d category pages were found.\n", numPages);
        JSONArray productsJSON = new JSONArray();
        JSONArray addJSONArray;
        if (numPages > 0) {
            for (int i = 1; i <= numPages; i++) {
                addJSONArray = parseCategoryPage(String.format("%s/page=%d\n", url, i));
                for (int addIndex = 0; addIndex < addJSONArray.length(); addIndex++) {
                    try {
                        productsJSON.put(addJSONArray.getJSONObject(addIndex));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            addJSONArray = parseCategoryPage(url);
            for (int addIndex = 0; addIndex < addJSONArray.length(); addIndex++) {
                try {
                    productsJSON.put(addJSONArray.getJSONObject(addIndex));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        File generalInfoOut = new File("./data/generalScrapedInfo.csv");
        try {
            String generalJSONinSTR = CDL.toString(productsJSON);
            FileUtils.writeStringToFile(generalInfoOut, generalJSONinSTR);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray parseCategoryPage(String url) {
        Document doc;
        JSONArray productsJSON = new JSONArray();
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
            return productsJSON;
        }
        Elements goodsElements = doc.select("div.g-i-tile-i-box");
        Elements ratingLinkElements;
        String ratingLink;
        productsJSON = getPageJSON(doc);
        Elements starsElements;
        String stars;
        int numberReviews = 0;
        int index = 0;
        for (Element goodsEl : goodsElements) {
            ratingLinkElements = goodsEl.select("a.g-rating-reviews-link");
            if (ratingLinkElements.size() > 0) {
                ratingLink = ratingLinkElements.first().attr("href");
                numberReviews = parseReviews(ratingLink);
            }
            starsElements = goodsEl.select("span.g-rating-stars-i");
            if (starsElements.size() > 0) {
                stars = getPercentagesFormat(starsElements.first().attr("style"));
            } else {
                stars = "None";
            }
            try {
                productsJSON.getJSONObject(index).put("stars", stars);
                productsJSON.getJSONObject(index).put("numberReviews", numberReviews);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            index++;
        }
        return productsJSON;
    }

    public static int parseReviews(String url) {
        Document doc;
        List<String[]> sentiments = new ArrayList<String[]>();
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        Elements numPagesElements = doc.select("a.paginator-catalog-l-link");
        Integer numPages = 0;
        if (numPagesElements.size() > 0) {
            numPages = Integer.parseInt(numPagesElements.last().text());
        }
        String pageUrl;
        if (numPages > 0) {
            for (int i = 1; i <= numPages; i++) {
                pageUrl = String.format("%spage=%d/", url, i);
                sentiments.addAll(parseReviewsPage(pageUrl));
            }
        } else {
            sentiments.addAll(parseReviewsPage(url));
        }
        String fileName = "./data/" + url.split("/")[4] + ".csv";
        writeCSV(fileName, sentiments);
        // Don't print printf("%d starred reviews were found. on url %s\n", sentiments.size(), url);
        return sentiments.size();
    }

    public static List<String[]> parseReviewsPage(String url) {
        Document doc;
        List<String[]> sentiments = new ArrayList<String[]>();
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
            return sentiments;
        }
        Elements star;
        Elements texts;
        Elements reviews = doc.select("article.pp-review-i");
        for (Element review : reviews) {
            star = review.select("span.g-rating-stars-i");
            texts = review.select("div.pp-review-text");
            if (star.size() > 0) {
                texts = texts.select("div.pp-review-text-i");
                sentiments.add(new String[]{star.first().attr("content"), texts.first().text()});
            }
        }

        return sentiments;
    }

    private static String getPercentagesFormat(String line) {
        return line.substring(line.indexOf(":") + 1, line.length() - 1);
    }

    private static void printf(String msg, Object... args) {
        System.out.print(String.format(msg, args));
    }
}
