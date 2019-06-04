package xyz.stxkfzx.manager.face.faceDbOperation;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.face.utils.*;
import java.util.*;

public class GetGroups
{
    public static Groups get() {
        final String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getlist";
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", 0);
            map.put("length", 100);
            final String param = GsonUtils.toJson((Object)map);
            final String accesstoken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accesstoken, "application/json", param);
            final Groups groups = (Groups)JsonUtils.jsonToPojo(result, Groups.class);
            return groups;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
