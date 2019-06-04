package xyz.stxkfzx.manager.face.faceDbOperation;

import xyz.stxkfzx.manager.face.utils.*;
import java.util.*;

public class FaceSearch
{
    public static String search(String imgBase64) {
        final String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imgBase64);
            map.put("liveness_control", "NONE");
            map.put("group_id_list", "0601");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");
            final String param = GsonUtils.toJson((Object)map);
            final String accessToken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
