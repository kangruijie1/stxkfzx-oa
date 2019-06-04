package xyz.stxkfzx.manager.face.faceDbOperation;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.face.utils.*;
import java.util.*;

public class GetUser
{
    public static FaceUser getUser(final String group_id, final String user_id) {
        final String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/getlist";
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", user_id);
            map.put("group_id", group_id);
            final String param = GsonUtils.toJson((Object)map);
            final String accesstoken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accesstoken, "application/json", param);
            System.out.println(result);
            final FaceUser user = (FaceUser)JsonUtils.jsonToPojo(result, FaceUser.class);
            System.out.println(user);
            return user;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
