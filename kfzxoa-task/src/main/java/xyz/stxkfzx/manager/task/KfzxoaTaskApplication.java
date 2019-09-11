package xyz.stxkfzx.manager.task;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"xyz.stxkfzx.manager.task.mapper"})
@EnableDubbo
public class KfzxoaTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfzxoaTaskApplication.class, args);
    }

}
