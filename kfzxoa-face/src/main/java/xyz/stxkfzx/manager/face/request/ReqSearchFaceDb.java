package xyz.stxkfzx.manager.face.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.face.utils.GetAccessToken;
import xyz.stxkfzx.manager.face.utils.GsonUtils;
import xyz.stxkfzx.manager.face.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("parm")
@PropertySource("classpath:reqParmConfig/searchFaceDbConfig.properties")
public class ReqSearchFaceDb {

    private final Logger logger = LoggerFactory.getLogger(ReqSearchFaceDb.class);

    private Map<String, String> map = new HashMap<>();

    private String url = new String();

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getUrl() {
        return url;
    }

    public void setImgParm(String imgParm){
        map.put("image", imgParm);
    }

    public String req() {
        try {
            String param = GsonUtils.toJson((Object) map);
            String resultStr = HttpUtil.post(url, GetAccessToken.getAuth(), "application/json", param);
            return resultStr;
        } catch (Exception e) {
            logger.error("搜索人脸库失败");
            logger.error(e.toString());
            throw new OAException(e.getMessage());
        }
    }
}
