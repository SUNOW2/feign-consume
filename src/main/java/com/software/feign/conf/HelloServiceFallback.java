package com.software.feign.conf;


import com.software.feign.po.User;
import com.software.feign.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务降级配置：服务降级逻辑的实现只需要为Feign客户端的定义接口编写一个具体的接口实现类。
 * 然后，通过@FeignClient注解的fallback属性来指定对应的服务降级实现类
 */
public class HelloServiceFallback implements HelloService {


    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }
}

/**
 * @RequestHeader:可以把Request请求header部分的值绑定到方法的参数上
 * @RequestParam:(1)处理简单类型的绑定，通过Request.getParameter()获取String直接转换成简单类型
 *               (2)用来处理Content-Type为application/x-www-form-urlencoded编码的内容，提交方式GET、POST
 *               (3)该注解有两个属性：value、required,value用于指定要传入的id的名称，require用来指定参数是否必须绑定
 * @RequestBody:该注解用于处理Content-Type不是application/x-www-form-urlencoded编码的内容，
 *               它是通过使用HandlerAdapater配置的HttpMessageConverters来解析post data body，然后绑定到相应的bean上
 *
 */
