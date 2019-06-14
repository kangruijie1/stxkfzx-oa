package xyz.stxkfzx.manager.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.stxkfzx.manager")
@MapperScan("xyz.stxkfzx.manager.user.mapper")
@EnableDubbo
public class KfzxoaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfzxoaUserApplication.class, args);
    }

}
