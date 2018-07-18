package com.software.feign.service;

import com.software.feign.po.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;

/**
 * @FeignClient注解指定服务名来绑定服务，然后使用 Spring MVC的注解来绑定具体该服务提供的REST接口
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

    /**
     * @RequestParam、@RequestHeader等可以指定参数名称的注解，它们的value不能少。在Spring MVC程序中，
     * 这些注解会根据参数名来作为默认值，但是在Feign中绑定参数必须通过value属性来指明具体的参数名。
     */
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
