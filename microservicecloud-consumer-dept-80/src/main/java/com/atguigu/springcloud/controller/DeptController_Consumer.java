package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
	/**
	 * 使用RestTemplate访问restful接口非常简单
	 * （url,requestMap,ResponseBean.class）这三个参数分别代表REST请求地址、请求参数、HTTP响应转换成的对象类型
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
	}
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
	}
	
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> get() {
		
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
	}
	
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
	
}
