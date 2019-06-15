package xyz.stxkfzx.manager.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:authConfig.properties")
public class AuthConfig {
    public static List<String> managerMethodList = new ArrayList<>();
    public static List<Short> managerCodeList = new ArrayList<>();
}
