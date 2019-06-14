package xyz.stxkfzx.manager.auth;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.stxkfzx.manager.auth.mapper")
@EnableDubbo
public class KfzxoaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfzxoaAuthApplication.class, args);
    }
}
