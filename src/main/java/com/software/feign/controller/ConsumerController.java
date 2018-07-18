package com.software.feign.controller;

import com.software.feign.po.PhoneUser;
import com.software.feign.po.User;
import com.software.feign.service.HelloService;
import com.software.feign.service.RefactorHelloService;
import com.software.feign.service.RefactorPhoneMessageService;
import com.software.phonemessageapi.po.LoginPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @Autowired
    RefactorPhoneMessageService refactorPhoneMessageService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI", 30)).append("\n");
        sb.append(helloService.hello(new User("DIDI", 30))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("DIDI")).append("\n");
        sb.append(refactorHelloService.hello("DIDI", 30)).append("\n");
        sb.append(refactorHelloService.hello(new po.User("DIDI", 30))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer4", method = RequestMethod.GET)
    public void feignConsumer4() {
        LoginPo loginPo = new LoginPo();
        System.out.println('\n');
        System.out.println("GET " + refactorPhoneMessageService.hello());
        System.out.println('\n');
        System.out.println("GET Integer = " + refactorPhoneMessageService.hello(16));
        System.out.println('\n');
        System.out.println("GET Integer String = " + refactorPhoneMessageService.hello(16, "123"));
        System.out.println('\n');
        System.out.println("POST LoginPo = " + refactorPhoneMessageService.insert(loginPo));
    }
}
