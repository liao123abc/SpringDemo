package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * todo 使用builder模式针对保利视频进行重构和测试，写一篇博文介绍builder模式
 * 1.常用的ui组件使用builder模式
 * 2.使用builder模式封装好httpclient来进行操作
 */
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.example.demo.dao")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
