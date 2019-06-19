package xyz.stxkfzx.manager.face.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.face.ai.pojo.AiSelUserInfoBase;
import xyz.stxkfzx.manager.face.utils.GetAccessToken;
import xyz.stxkfzx.manager.face.utils.GsonUtils;
import xyz.stxkfzx.manager.face.utils.HttpUtil;
import xyz.stxkfzx.manager.face.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("sel.user.info")
@PropertySource("classpath:reqParmConfig/selUserInfoConfig.properties")
public class ReqSelUserInfo {
    private String url = new String();
    private Map<String, String> map = new HashMap<>();

    public String req(String userId, String groupId){
        AiSelUserInfoBase base = new AiSelUserInfoBase();
        try {
            map.put("user_id", userId);
            map.put("group_id", groupId);
            String param = GsonUtils.toJson((Object)map);
            String accesstoken = GetAccessToken.getAuth();
            String result = HttpUtil.post(url, accesstoken, "application/json", param);
            base = (AiSelUserInfoBase) JsonUtils.jsonToPojo(result, AiSelUserInfoBase.class);
            if(base.getError_code() == 0){
                return base.getResult().getUser_list().get(0).getUser_info();
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAException("请求查询用户信息失败 " + base.getError_msg());
        }
    }

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
