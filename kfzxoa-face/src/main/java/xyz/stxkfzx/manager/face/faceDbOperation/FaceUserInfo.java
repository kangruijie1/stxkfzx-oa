package xyz.stxkfzx.manager.face.faceDbOperation;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.face.utils.*;
import java.util.*;

public class FaceUserInfo
{
    public static FaceUserResultUserList get(final String group_id, final String user_id) {
        final String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/get";
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", user_id);
            map.put("group_id", group_id);
            final String param = GsonUtils.toJson((Object)map);
            final String accesstoken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accesstoken, "application/json", param);
            final FaceUserResultUserList jsonToPojo = (FaceUserResultUserList)JsonUtils.jsonToPojo(result, FaceUserResultUserList.class);
            return jsonToPojo;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
