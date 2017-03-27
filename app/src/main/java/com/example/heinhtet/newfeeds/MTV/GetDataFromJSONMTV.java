package com.example.heinhtet.newfeeds.MTV;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/21/17.
 */

public class GetDataFromJSONMTV {

    public GetDataFromJSONMTV() {

    }

    public static final List<MTV> getDataFromJsonMTV(String link) {
        URL url = createUrl(link);
        String jsonResponce = "";
        jsonResponce = makeHttpClient(url);

        List<MTV> getData = extractJsonResponce(jsonResponce);
        return getData;

    }

    private static List<MTV> extractJsonResponce(String jsonResponce) {
        List<MTV> data = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonResponce);
            JSONArray array = jsonObject.getJSONArray("articles");
            for (int index = 0; index < array.length(); index++) {
                JSONObject getObject = array.getJSONObject(index);
                data.add(new MTV(getObject.getString("title"),
                        getObject.getString("description"),
                        getObject.getString("urlToImage"),
                        getObject.getString("url"),
                        getObject.getString("publishedAt"),
                        getObject.getString("author")
                ));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

    private static String makeHttpClient(URL url) {
        HttpURLConnection httpURLConnection = null;
        InputStream stream = null;
        String jsonResponce = "";

        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200) {
                stream = httpURLConnection.getInputStream();
                jsonResponce = ReadInputStream(stream);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return jsonResponce;
    }

    private static String ReadInputStream(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(stream, Charset.forName("UTF-8"));
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();
        while (line != null) {
            builder.append(line);
            line = buffer.readLine();
        }
        return builder.toString();


    }

    private static URL createUrl(String link) {
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
