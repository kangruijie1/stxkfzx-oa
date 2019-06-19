package xyz.stxkfzx.manager.face.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.face.ai.pojo.AiAddFaceBase;
import xyz.stxkfzx.manager.face.utils.GetAccessToken;
import xyz.stxkfzx.manager.face.utils.GsonUtils;
import xyz.stxkfzx.manager.face.utils.HttpUtil;
import xyz.stxkfzx.manager.face.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("add.face")
@PropertySource("classpath:reqParmConfig/addFaceConfig.properties")
public class ReqAddFace {
    public AiAddFaceBase req(String image, String departmentId, String userId, String username) {
        AiAddFaceBase base = new AiAddFaceBase();
        try {
            map.put("image", image);
            map.put("group_id", departmentId);
            map.put("user_id", userId);
            map.put("user_info", username);
            final String param = GsonUtils.toJson((Object) map);
            final String accesstoken = GetAccessToken.getAuth();
            final String result = HttpUtil.post(url, accesstoken, "application/json", param);
            base = JsonUtils.jsonToPojo(result, AiAddFaceBase.class);
            return base;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAException("请求添加人脸失败 " + base.getError_msg());
        }
    }

    private String url = new String();

    private Map<String, String> map = new HashMap<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
