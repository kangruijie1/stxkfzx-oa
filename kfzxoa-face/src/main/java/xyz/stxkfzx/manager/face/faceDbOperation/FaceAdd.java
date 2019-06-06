package xyz.stxkfzx.manager.face.faceDbOperation;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.face.utils.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.util.*;
import java.io.*;

public class FaceAdd
{
    public static FaceAddResult add(final String imageBase64, final String group_id, final String user_id, final String user_info) {
        final String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imageBase64);
            map.put("group_id", group_id);
            map.put("user_id", user_id);
            map.put("user_info", user_info);
            map.put("liveness_control", "NONE");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");
            final String param = GsonUtils.toJson((Object)map);
            final String accesstoken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accesstoken, "application/json", param);
            final FaceAddResult faceAddResult = (FaceAddResult)JsonUtils.jsonToPojo(result, FaceAddResult.class);
            return faceAddResult;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<TUser> addOther(final List<TUser> jsonToList, final String path) throws UnsupportedEncodingException {
        final List<TUser> resultList = new ArrayList<TUser>();
        final File dir = new File(path);
        final String group_id = dir.getName();
        final File[] listFiles = dir.listFiles();
        File[] array;
        for (int length = (array = listFiles).length, i = 0; i < length; ++i) {
            final File imageFile = array[i];
            if (!imageFile.isHidden()) {
                String user_info = imageFile.getName();
                user_info = user_info.substring(0, user_info.lastIndexOf("."));
                for (final TUser user : jsonToList) {
                    if (user_info.equals(user.getUsername())) {
                        final String user_id = user.getJobId();
                        final String imgBase64 = Base64Util.getImgBase64(imageFile.getPath());
                        System.out.println("-" + group_id + "-" + user_id + "-" + user_info);
                        final FaceAddResult add = add(imgBase64, group_id, user_id, user_info);
                        if (!"222304".equals(add.getError_code())) {
                            continue;
                        }
                        resultList.add(user);
                    }
                }
            }
        }
        return resultList;
    }
}
