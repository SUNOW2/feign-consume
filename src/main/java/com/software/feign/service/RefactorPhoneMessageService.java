package com.software.feign.service;

import com.software.phonemessageapi.service.PhoneMessageService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @ClassName RefactorPhoneMessageService
 * @Description
 * @Author 徐旭
 * @Date 2018/7/18 16:37
 * @Version 1.0
 */
@FeignClient("phone-message")
public interface RefactorPhoneMessageService extends PhoneMessageService {

}
