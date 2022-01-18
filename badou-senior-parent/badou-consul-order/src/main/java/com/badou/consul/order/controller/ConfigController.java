
package com.badou.consul.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badou.consul.order.entity.StudentConfig;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${myName}")
    private String myName;

    @Autowired
    private StudentConfig studentConfig;

    @RequestMapping("/myname")
    public String testHello() {
        System.out.println("my name is : " + myName);
        return myName;
    }

    @RequestMapping("/config")
    public String testConfig() {
        System.out.println("Test");
        System.out.println(studentConfig.toString());
        return studentConfig.toString();
    }

}
