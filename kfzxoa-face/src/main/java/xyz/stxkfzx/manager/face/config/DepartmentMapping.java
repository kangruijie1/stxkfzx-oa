package xyz.stxkfzx.manager.face.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("department")
@PropertySource(value = "classpath:config/departmentConfig.properties", encoding = "UTF-8" )
public class DepartmentMapping {
    private Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
