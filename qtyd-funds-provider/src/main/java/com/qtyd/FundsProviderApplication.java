package com.qtyd;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/***
 * 项目启动类
 */

import com.qtyd.controller.funds.FundsController;
import com.qtyd.controller.funds.RunController;
import com.qtyd.service.impl.FundsServiceImpl;
@Configuration
@Import({
	Swagger2.class,
	FundsController.class,
	FundsServiceImpl.class,
	RunController.class
})
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//阻止springboot自动注入datasource
@EnableEurekaClient
@ComponentScan(basePackages={"com.qtyd.dao","com.qtyd.db"})//"com.qtyd.controller","com.qtyd.service"
//@MapperScan(basePackages = "com.qtyd.dao", sqlSessionFactoryRef = "sqlSessionFactory")
@MapperScan("com.qtyd.dao")
//@EnableSpringDataWebSupport
public class FundsProviderApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(FundsProviderApplication.class).web(true).run(args);
	}
}
