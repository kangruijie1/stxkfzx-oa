package xyz.stxkfzx.manager.face.faceDbOperation;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.face.utils.*;
import java.util.*;

public class GetGroup
{
    public static Group getUsers(final String group_id) {
        final String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getusers";
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("group_id", group_id);
            final String param = GsonUtils.toJson((Object)map);
            final String accesstoken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accesstoken, "application/json", param);
            final Group group = (Group)JsonUtils.jsonToPojo(result, Group.class);
            return group;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
