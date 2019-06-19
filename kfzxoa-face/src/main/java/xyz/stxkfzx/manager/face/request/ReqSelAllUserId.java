package xyz.stxkfzx.manager.face.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.face.ai.pojo.AiSelAllUserIdBase;
import xyz.stxkfzx.manager.face.utils.GetAccessToken;
import xyz.stxkfzx.manager.face.utils.GsonUtils;
import xyz.stxkfzx.manager.face.utils.HttpUtil;
import xyz.stxkfzx.manager.face.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("sel.all.userid")
@PropertySource("classpath:reqParmConfig/selAllUserIdConfig.properties")
public class ReqSelAllUserId {
    private String url = new String();
    Map<String, String> map = new HashMap<>();

    public AiSelAllUserIdBase req(String departmentId){

        AiSelAllUserIdBase base = new AiSelAllUserIdBase();
        try {
            map.put("group_id", departmentId);

            String param = GsonUtils.toJson((Object)map);
            String accesstoken = GetAccessToken.getAuth();
            String result = null;
            result = HttpUtil.post(url, accesstoken, "application/json", param);
            base = (AiSelAllUserIdBase) JsonUtils.jsonToPojo(result, AiSelAllUserIdBase.class);
            if(base.getError_code() == 0 && base.getResult().getUser_id_list().size() != 0){
                return base;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAException("请求获取组内所有用户id失败 " + base.getError_msg());
        }
    }
    public String getUrl() {
        return url;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
