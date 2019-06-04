package xyz.stxkfzx.manager.face.utils;

import java.net.*;
import java.io.*;
import java.util.*;

public class HttpUtil
{
    public static String post(final String requestUrl, final String accessToken, final String params) throws Exception {
        final String contentType = "application/x-www-form-urlencoded";
        return post(requestUrl, accessToken, contentType, params);
    }
    
    public static String post(final String requestUrl, final String accessToken, final String contentType, final String params) throws Exception {
        String encoding = "UTF-8";
        if (requestUrl.contains("nlp")) {
            encoding = "GBK";
        }
        return post(requestUrl, accessToken, contentType, params, encoding);
    }
    
    public static String post(final String requestUrl, final String accessToken, final String contentType, final String params, final String encoding) throws Exception {
        final String url = String.valueOf(requestUrl) + "?access_token=" + accessToken;
        return postGeneralUrl(url, contentType, params, encoding);
    }
    
    public static String postGeneralUrl(final String generalUrl, final String contentType, final String params, final String encoding) throws Exception {
        final URL url = new URL(generalUrl);
        final HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        final DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.write(params.getBytes(encoding));
        out.flush();
        out.close();
        connection.connect();
        final Map<String, List<String>> headers = connection.getHeaderFields();
        for (final String key : headers.keySet()) {
            System.err.println(String.valueOf(key) + "--->" + headers.get(key));
        }
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result = String.valueOf(result) + getLine;
        }
        in.close();
        System.err.println("result:" + result);
        return result;
    }
}
