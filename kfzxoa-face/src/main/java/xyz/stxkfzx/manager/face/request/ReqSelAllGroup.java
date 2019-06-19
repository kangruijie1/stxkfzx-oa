package xyz.stxkfzx.manager.face.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.face.ai.pojo.AiSelAllGroupBase;
import xyz.stxkfzx.manager.face.pojo.Groups;
import xyz.stxkfzx.manager.face.utils.GetAccessToken;
import xyz.stxkfzx.manager.face.utils.GsonUtils;
import xyz.stxkfzx.manager.face.utils.HttpUtil;
import xyz.stxkfzx.manager.face.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("sel.all.group")
@PropertySource("classpath:reqParmConfig/selAllGroupConfig.properties")
public class ReqSelAllGroup {
    private String url = new String();
    private Map<String, Integer> map = new HashMap<>();

    public AiSelAllGroupBase req(){
        try {
            String param = GsonUtils.toJson((Object)map);
            String accesstoken = GetAccessToken.getAuth();
            String result = HttpUtil.post(url, accesstoken, "application/json", param);
            AiSelAllGroupBase groups = (AiSelAllGroupBase) JsonUtils.jsonToPojo(result, AiSelAllGroupBase.class);
            return groups;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAException("请求获取所有组失败");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
