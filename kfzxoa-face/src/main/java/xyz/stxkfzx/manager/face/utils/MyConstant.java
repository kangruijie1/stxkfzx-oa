package xyz.stxkfzx.manager.face.utils;

import org.springframework.beans.factory.annotation.*;

public final class MyConstant
{
    @Value("${API_KEY}")
    public static String API_KEY;
    @Value("${SECRET_KEY}")
    public static String SECRET_KEY;
    @Value("${ACCESSTOKEN}")
    public static String ACCESSTOKEN;
    @Value("${STX_KFZX_WIFI_S}")
    public static String STX_KFZX_WIFI_S;
}
