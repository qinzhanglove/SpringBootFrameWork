package com.springboot.frame.soap.impl;

import com.springboot.frame.soap.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Created by jack rose on 2017/11/25.
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://soap.frame.springboot.com/", // 与接口中的命名空间一致,一般是接口的包名倒序
        endpointInterface = "com.springboot.frame.soap.CommonService"// 接口地址
)
@Component
public class CommonServiceImp implements CommonService {

    @Override
    public String sayHello(String name) {
        System.out.println(name);
        return "Hello ," + name;
    }

}
