package com.atguuigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguuigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method= RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id")Long id) {
		return service.get(id);
	}
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		service.list().forEach(item->{
			System.out.println(item);
		});
		return service.list();
	}
	
	@RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
	public Object discovery() {
		List<String>list=client.getServices();
		System.out.println("****************"+list);
		
		//相当于查找MICROSERVICECLOUD-DEPT服务
		List<ServiceInstance>srvList=client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
		}
		return this.client;
	}
}
