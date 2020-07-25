package xyz.yship.zhiliao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("xyz.yship.zhiliao.mapper")
@SpringBootApplication
public class ZhiliaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhiliaoApplication.class, args);
	}

}
