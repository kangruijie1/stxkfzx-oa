package xyz.stxkfzx.manager.face.utils;

import com.fasterxml.jackson.core.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;

public class JsonUtils
{
    private static final ObjectMapper MAPPER;
    
    static {
        MAPPER = new ObjectMapper();
    }
    
    public static String objectToJson(final Object data) {
        try {
            final String string = JsonUtils.MAPPER.writeValueAsString(data);
            return string;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static <T> T jsonToPojo(final String jsonData, final Class<T> beanType) {
        try {
            final T t = (T)JsonUtils.MAPPER.readValue(jsonData, (Class)beanType);
            return t;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static <T> List<T> jsonToList(final String jsonData, final Class<T> beanType) {
        final JavaType javaType = JsonUtils.MAPPER.getTypeFactory().constructParametricType((Class)List.class, new Class[] { beanType });
        try {
            final List<T> list = (List<T>)JsonUtils.MAPPER.readValue(jsonData, javaType);
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
