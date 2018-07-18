package com.software.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import service.HelloService;

/**
 * 使用Spring Cloud Feign继承特性，可以将接口的定义从Controller中剥离，同时配合Maven私有仓库就可以轻易的实现接口定义的共享，
 * 实现在构建期的接口绑定，从而减少服务客户端的绑定设置，但是，由于接口在构建期间就建立起了依赖，那么接口变动就会对项目构建造成影响，
 * 可能服务提供方修改了一个接口定义，那么会导致客户端工程的构建失败
 *
 * @FeignClient在创建Feign客户端的同时，也创建了一个名为HELLO-SERVICE的Ribbon客户端
 */

@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {
}
