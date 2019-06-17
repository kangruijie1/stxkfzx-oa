package xyz.stxkfzx.manager.face;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.stxkfzx.manager")
@MapperScan({"xyz.stxkfzx.manager.face.mapper"})
@EnableDubbo
public class KfzxoaFaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfzxoaFaceApplication.class, args);
    }

}
