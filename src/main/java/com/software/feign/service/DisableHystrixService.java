package com.software.feign.service;

import com.software.feign.conf.DisableHystrixConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "HELLO-SERVICE", configuration = DisableHystrixConfiguration.class)
public interface DisableHystrixService {

}
