package siddharam.goranale;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        String urlString = "https://api.chucknorris.io/jokes/random";
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
            System.out.println("created_at : "+jsonObject.get("created_at"));
            System.out.println("value : "+jsonObject.get("value"));
            System.out.println("url : "+jsonObject.get("url"));
            System.out.println("icon_url : "+jsonObject.get("icon_url"));

            System.out.println("_________________________________");
            System.out.println();
            System.out.println(jsonObject.toString());


        } else {
            System.out.println("API call Not");
        }
    }
}
