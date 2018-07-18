package com.software.feign.service;

import com.software.feign.po.LoginPo;
import com.software.feign.po.ResponseEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName PhoneMessageService
 * @Description
 * @Author 徐旭
 * @Date 2018/7/18 15:25
 * @Version 1.0
 */
@FeignClient("phone-message")
public interface PhoneMessageService {

    /**
     * 绑定phone-message中"/hello"接口的声明
     * @return
     */
    @RequestMapping(value = "/hello")
    ResponseEntity hello();

    /**
     * 绑定phone-message中"/hello1"接口的声明
     * @param id
     * @return
     */
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    ResponseEntity hello(@RequestParam Integer id);

    /**
     * 绑定phone-message中"/hello2"接口的声明
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    ResponseEntity hello(@RequestHeader("id") Integer id, @RequestHeader("password") String password);

    /**
     * 绑定phone-message中"/insert"接口的声明
     * @param loginPo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ResponseEntity insert(@RequestBody LoginPo loginPo);
}
