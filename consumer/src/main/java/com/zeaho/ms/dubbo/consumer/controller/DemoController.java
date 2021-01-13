package com.zeaho.ms.dubbo.consumer.controller;

import com.zeaho.ms.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lzzz
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @DubboReference
    private DemoService demoService;

    @Resource(name = "providerRestTemplate")
    private RestTemplate providerRestTemplate;

    @GetMapping("/dubbo/hello")
    public String sayHello(@RequestParam("name") String name) {
        return demoService.sayHello(name);
    }

    @GetMapping("/rest/hello")
    public String sayHelloRest(@RequestParam("name") String name) {
        return providerRestTemplate.getForObject("/demo/hello", String.class);
    }
}
