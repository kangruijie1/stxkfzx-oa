package xyz.stxkfzx.manager.face.utils;

import com.baidu.aip.face.*;

public class GetClient
{
    public static final String APP_ID = "14926883";
    public static final String API_KEY = "fP9akjdaO3EAzFB21r9Wx8ug";
    public static final String SECRET_KEY = "CUsw5i4AY6WOV3H36rNkpbI3RUTSy0uY";
    
    public static AipFace get() {
        final AipFace client = new AipFace("14926883", "fP9akjdaO3EAzFB21r9Wx8ug", "CUsw5i4AY6WOV3H36rNkpbI3RUTSy0uY");
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }
}
