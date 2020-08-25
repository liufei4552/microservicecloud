package com.atguigu.myrule;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 官方说明此类不能放在@ComponentScan所在的包及其子包下面，因为主启动类中的@SpringBootApplication包含了此注解所以需要另建新包存放
 * 
 * @author admin
 *
 */
@Configuration
public class MySelfRule {

	/*
	 * @Bean public IRule myIRule() { return new RoundRobinRule(); }
	 */

	@Bean
	public IRule myIRule() {
		return new RandomRule_LF();
	}
}
