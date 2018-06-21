package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



/**
 * 
* @ClassName: EurekaApplication   
* @Description: EurekaApplication 上面的 EnableEurekaServer 注解就保证 eureka 服务器能正常启动  
* @author 迟雪
* @date 2018年6月20日 下午4:17:01   
*
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaApplication.class).web(true).run(
				args);
	}

}