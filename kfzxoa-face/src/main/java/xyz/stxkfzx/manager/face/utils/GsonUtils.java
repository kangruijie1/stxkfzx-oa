package xyz.stxkfzx.manager.face.utils;

import com.google.gson.*;
import java.lang.reflect.*;

public class GsonUtils
{
    private static Gson gson;
    
    static {
        GsonUtils.gson = new GsonBuilder().create();
    }
    
    public static String toJson(final Object value) {
        return GsonUtils.gson.toJson(value);
    }
    
    public static <T> T fromJson(final String json, final Class<T> classOfT) throws JsonParseException {
        return (T)GsonUtils.gson.fromJson(json, (Class)classOfT);
    }
    
    public static <T> T fromJson(final String json, final Type typeOfT) throws JsonParseException {
        return (T)GsonUtils.gson.fromJson(json, typeOfT);
    }
}
