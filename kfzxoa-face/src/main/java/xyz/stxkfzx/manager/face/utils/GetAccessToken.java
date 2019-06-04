package xyz.stxkfzx.manager.face.utils;

import java.net.*;
import java.io.*;
import org.json.*;
import java.util.*;

public class GetAccessToken
{
    public static String getAuth() {
        final String clientId = "fP9akjdaO3EAzFB21r9Wx8ug";
        final String clientSecret = "CUsw5i4AY6WOV3H36rNkpbI3RUTSy0uY";
        return getAuth(clientId, clientSecret);
    }
    
    public static String getAuth(final String ak, final String sk) {
        final String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        final String getAccessTokenUrl = String.valueOf(authHost) + "grant_type=client_credentials" + "&client_id=" + ak + "&client_secret=" + sk;
        try {
            final URL realUrl = new URL(getAccessTokenUrl);
            final HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            final Map<String, List<String>> map = connection.getHeaderFields();
            for (final String key : map.keySet()) {
                System.err.println(String.valueOf(key) + "--->" + map.get(key));
            }
            final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result = String.valueOf(result) + line;
            }
            System.err.println("result:" + result);
            final JSONObject jsonObject = new JSONObject(result);
            final String access_token = jsonObject.getString("access_token");
            return access_token;
        }
        catch (Exception e) {
            System.err.printf("\u83b7\u53d6token\u5931\u8d25\uff01", new Object[0]);
            e.printStackTrace(System.err);
            return null;
        }
    }
}
