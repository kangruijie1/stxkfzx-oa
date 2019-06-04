package xyz.stxkfzx.manager.face;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.stxkfzx.manager.user.mapper")
@MapperScan("xyz.stxkfzx.manager.face.mapper")
public class KfzxoaFaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfzxoaFaceApplication.class, args);
    }

}
