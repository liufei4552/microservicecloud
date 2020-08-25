package com.atguigu.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
	/*
	 * //改变riboon的负载均衡算法
	 * 
	 * @Bean public IRule myRule() { return new RandomRule(); }
	 */
}
