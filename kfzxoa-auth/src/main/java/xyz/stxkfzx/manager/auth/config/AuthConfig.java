package xyz.stxkfzx.manager.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "list")
@PropertySource("classpath:authConfig.properties")
public class AuthConfig {
    public List<String> managerMethodList = new ArrayList<>();
    public List<Integer> managerCodeList = new ArrayList<>();

    public void setManagerMethodList(List<String> managerMethodList) {
        this.managerMethodList = managerMethodList;
    }

    public void setManagerCodeList(List<Integer> managerCodeList) {
        this.managerCodeList = managerCodeList;
    }
}
