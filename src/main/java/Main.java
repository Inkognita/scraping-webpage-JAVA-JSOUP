
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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    String myUrl = "https://bt.rozetka.com.ua/ua/coffee_machines/c80164/filter/";

    public static void main(String[] args) throws IOException, InterruptedException {

        Main.parseCategory("https://bt.rozetka.com.ua/ua/coffee_machines/c80164/filter/");
        //jsP();
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
    public static void jsP() {
        JSONObject js=null;
        try {
            js = new JSONObject("{\"JS\" : 1}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(js.get("JS"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public static void mmmM() throws JSONException {
        JSONArray productsJSON = new JSONArray("[{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"197689\",\"productVendorID\":\"152\",\"productMerchantID\":2,\"productPosition\":\"0\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":80,\"productName\":\"Кавоварка GORENJE TCM 300 W\",\"productPrice\":\"24.63\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"301161\",\"productVendorID\":\"3096\",\"productMerchantID\":2,\"productPosition\":\"1\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":66,\"productName\":\"Крапельна кавоварка MAGIO MG-344\",\"productPrice\":\"15.67\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"84696\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"2\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":1,\"productName\":\"Кавомашина DELONGHI ECAM 23.210 B +набір стаканів DELONGHI\",\"productPrice\":\"455.37\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"3142655\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"3\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":20,\"productName\":\"Кавомашина DELONGHI ETAM 29.660.SB + набір стаканів DELONGHI\",\"productPrice\":\"721.02\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"14458946\",\"productVendorID\":\"182\",\"productMerchantID\":2,\"productPosition\":\"4\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":2,\"productName\":\"Кавомашина SAECO Incanto HD8912/09\",\"productPrice\":\"569.22\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"8607775\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"5\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":4,\"productName\":\"Кавоварка еспресо DELONGHI ECP 35.31 BK Silver\",\"productPrice\":\"189.72\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"12284217\",\"productVendorID\":\"216\",\"productMerchantID\":2,\"productPosition\":\"6\",\"productLocation\":\"Catalog\",\"stars\":\"80\",\"numberReviews\":13,\"productName\":\"Кавоварка еспресо VITEK VT-1525 BK\",\"productPrice\":\"98.48\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"2483507\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"7\",\"productLocation\":\"Catalog\",\"stars\":\"80\",\"numberReviews\":11,\"productName\":\"Кавоварка DELONGHI EC 153 B\",\"productPrice\":\"106.22\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"6284565\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"8\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":6,\"productName\":\"Кавомашина DELONGHI ECAM 23.464 S+набір стаканів DELONGHI\",\"productPrice\":\"683.07\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"12238465\",\"productVendorID\":\"182\",\"productMerchantID\":2,\"productPosition\":\"9\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":4,\"productName\":\"Кавомашина SAECO Incanto HD8916/09\",\"productPrice\":\"629.94\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"1542977\",\"productVendorID\":\"23\",\"productMerchantID\":2,\"productPosition\":\"10\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":11,\"productName\":\"Кавоварка PHILIPS Daily Collection HD7457/20\",\"productPrice\":\"45.5\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"303286\",\"productVendorID\":\"216\",\"productMerchantID\":2,\"productPosition\":\"11\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":11,\"productName\":\"Кавоварка VITEK VT-1514 BK\",\"productPrice\":\"168.31\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"39965\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"12\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":5,\"productName\":\"Кавомашина DELONGHI ESAM 3200 S +набір стаканів DELONGHI\",\"productPrice\":\"379.47\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"512160\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"13\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":3,\"productName\":\"Кавомашина DELONGHI ECAM 23.460 B + Кава KIMBO\",\"productPrice\":\"622.35\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"80715\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"14\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":18,\"productName\":\"Кавомашина DELONGHI ESAM 4000 B+набір стаканів DELONGHI\",\"productPrice\":\"379.47\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"193245\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"15\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":15,\"productName\":\"Кавомашина DELONGHI ESAM 4200 S+набір стаканів DELONGHI\",\"productPrice\":\"360.49\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"4636335\",\"productVendorID\":\"23\",\"productMerchantID\":2,\"productPosition\":\"16\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":4,\"productName\":\"Кавомашина PHILIPS 2000 series HD8649/51\",\"productPrice\":\"341.52\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"18848130\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"17\",\"productLocation\":\"Catalog\",\"stars\":\"None\",\"numberReviews\":0,\"productName\":\"Кавомашина DELONGHI PrimaDonna S Evo ECAM 510.55.M\",\"productPrice\":\"1366.19\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"12477922\",\"productVendorID\":\"166\",\"productMerchantID\":2,\"productPosition\":\"18\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":1,\"productName\":\"Кавоварка BEKO BKK 2300 (по-турецки)\",\"productPrice\":\"121.4\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"211471\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"19\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":2,\"productName\":\"Кавомашина DELONGHI ESAM 04.350.S+набір стаканів DELONGHI\",\"productPrice\":\"569.22\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"11181853\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"20\",\"productLocation\":\"Catalog\",\"stars\":\"60\",\"numberReviews\":2,\"productName\":\"Кавоварка еспресо DELONGHI ECP 31.21 BK\",\"productPrice\":\"113.81\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"221493\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"21\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":6,\"productName\":\"Кавомашина DELONGHI ESAM 2600\",\"productPrice\":\"379.47\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"2692732\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"22\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":26,\"productName\":\"Кавоварка DELONGHI EC 156 B\",\"productPrice\":\"110.02\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"301158\",\"productVendorID\":\"3096\",\"productMerchantID\":2,\"productPosition\":\"23\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":21,\"productName\":\"Крапельна кавоварка MAGIO MG-342\",\"productPrice\":\"13.47\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"17219611\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"24\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":1,\"productName\":\"Кавоварка еспресо DELONGHI BCO 410.1 BLACK\",\"productPrice\":\"165.09\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"6308109\",\"productVendorID\":\"182\",\"productMerchantID\":2,\"productPosition\":\"25\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":11,\"productName\":\"Кавомашина SAECO Incanto HD8918/09\",\"productPrice\":\"673.62\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"2103572\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"26\",\"productLocation\":\"Catalog\",\"stars\":\"80\",\"numberReviews\":7,\"productName\":\"Кавоварка DELONGHI EC 146 B\",\"productPrice\":\"102.43\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"18128412\",\"productVendorID\":\"23\",\"productMerchantID\":2,\"productPosition\":\"27\",\"productLocation\":\"Catalog\",\"stars\":\"100\",\"numberReviews\":2,\"productName\":\"Кавомашина PHILIPS 2000 series HD8650/09\",\"productPrice\":\"284.59\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"100696\",\"productVendorID\":\"216\",\"productMerchantID\":2,\"productPosition\":\"28\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":49,\"productName\":\"Кавоварка VITEK VT-1511 BK\",\"productPrice\":\"87.1\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"17916528\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"29\",\"productLocation\":\"Catalog\",\"stars\":\"None\",\"numberReviews\":0,\"productName\":\"Кавоварка еспресо DELONGHI ESAM 2800 SB+набір стаканів DELONGHI\",\"productPrice\":\"379.47\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"129276\",\"productVendorID\":\"216\",\"productMerchantID\":2,\"productPosition\":\"30\",\"productLocation\":\"Catalog\",\"stars\":\"90\",\"numberReviews\":242,\"productName\":\"Кавоварка VITEK VT-1513 BK\",\"productPrice\":\"89.18\",\"productCondition\":\"new\"},{\"productSellerID\":5,\"productCategoryID\":\"80164\",\"productID\":\"105138\",\"productVendorID\":\"206\",\"productMerchantID\":2,\"productPosition\":\"31\",\"productLocation\":\"Catalog\",\"stars\":\"None\",\"numberReviews\":0,\"productName\":\"Кавоварка еспресо DELONGHI BCO 260 CD\",\"productPrice\":\"151.76\",\"productCondition\":\"new\"}]\n");
        File generalInfoOut = new File("./data/generalScrapedInfo.csv");
        productsJSON.put("asd");
        System.out.println(productsJSON.getJSONObject(1));
        try {
            String generalJSONinSTR = CDL.toString(productsJSON);
            System.out.println(generalJSONinSTR);
            FileUtils.writeStringToFile(generalInfoOut, generalJSONinSTR);
        } catch (JSONException e) {
            e.printStackTrace();
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
                //System.out.print(scriptInfoStr);
                try {
                    scriptInfo = new JSONObject(scriptInfoStr);
                    scriptInfoArray = scriptInfo.getJSONArray("products");
                    //System.out.println(scriptInfoArray);
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
                for (int addIndex=0; addIndex<addJSONArray.length(); addIndex++){
                    try {
                        productsJSON.put(addJSONArray.getJSONObject(addIndex));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            addJSONArray = parseCategoryPage(url);
            for (int addIndex=0; addIndex<addJSONArray.length(); addIndex++){
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
            if (starsElements.size() > 0){
                stars = getPercentagesFormat(starsElements.first().attr("style"));
            }
            else{
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
