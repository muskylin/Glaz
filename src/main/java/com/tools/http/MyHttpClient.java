package com.tools.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 14-3-1.
 */
public class MyHttpClient {
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
}
