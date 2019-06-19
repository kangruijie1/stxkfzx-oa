package xyz.stxkfzx.manager.face.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("ip")
@PropertySource("classpath:config/ipConfig.properties")
public class IsKfzxIpConfig      {
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
