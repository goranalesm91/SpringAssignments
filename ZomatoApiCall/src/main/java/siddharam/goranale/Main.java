package siddharam.goranale;

import org.json.JSONObject;


import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        String urlString = "https://api.zippopotam.us/us/33162";
        URL url = null;
        HttpURLConnection connection = null;
        int responce_code = 0;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("url problem");
        }
        try {
            connection = (HttpURLConnection) url.openConnection();
            responce_code = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("connection problem");
        }


        if (responce_code == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder apiData = new StringBuilder();
            String reafLine = null;
            while ((reafLine = in.readLine()) != null) {
                apiData.append(reafLine);
            }

            in.close();

            JSONObject jsonObject = new JSONObject(apiData.toString());
            System.out.println("_________________________________");
            System.out.println();
            System.out.println("country : "+jsonObject.get("country"));
            System.out.println("places : "+jsonObject.get("places").toString());
            System.out.println("country abbreviation : "+jsonObject.get("country abbreviation"));
            System.out.println("post code : "+jsonObject.get("post code"));

            System.out.println("_________________________________");
            System.out.println();
            System.out.println(jsonObject.toString());


        } else {
            System.out.println("API call Not");
        }
    }
}