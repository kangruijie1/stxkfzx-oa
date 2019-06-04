package xyz.stxkfzx.manager.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.stxkfzx.manager.user.mapper")
public class KfzxoaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfzxoaUserApplication.class, args);
    }

}
