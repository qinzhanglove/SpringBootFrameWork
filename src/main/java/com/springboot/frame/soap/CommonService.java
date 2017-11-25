package com.springboot.frame.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by jack rose on 2017/11/25.
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://soap.frame.springboot.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String sayHello(@WebParam(name = "userName") String name);

}
