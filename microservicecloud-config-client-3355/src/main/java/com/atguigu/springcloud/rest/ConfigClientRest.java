package com.atguigu.springcloud.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ConfigClientRest
 * @Description
 * @Author liufei
 * @Date 2020/8/27 16:00
 * @Version V1.0
 **/
@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;
    @RequestMapping("/config")
    public String getConfig(){
        String string="applicationName: "+applicationName+"\t eurekaServers:"+eurekaServers+"\t port:"+port;
        System.out.println(string);
        return string;
    }
}
