package com.tools.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-3-1.
 */
public class MyHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(MyHttpClient.class);

    public static byte[] readParse(String urlPath) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        URL url = new URL(urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream inStream = conn.getInputStream();

        while ((len = inStream.read(data)) != -1) {
            outStream.write(data, 0, len);

        }
        inStream.close();
        return outStream.toByteArray();

    }

    public static List<String> sendGet(String urlPath) {
        if (urlPath == null || urlPath.equals("")) {
            return null;
        }
        HttpURLConnection conn = null;
                BufferedReader reader = null;
        List<String> result = new ArrayList<String>();

        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            if (is.available() == 0){
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
conn.disconnect();
        } catch (Exception e) {
            logger.error("There are some wrongs!\\n" + e);
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
                if (conn != null){
                    conn.disconnect();
                }
            } catch (Exception e1) {
                logger.error("There are some wrongs!\\n" + e1);
            }
        }

        return result;
    }
}
