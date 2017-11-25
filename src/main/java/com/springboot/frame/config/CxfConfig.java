package com.springboot.frame.config;

import com.springboot.frame.soap.CommonService;
import com.springboot.frame.soap.impl.CommonServiceImp;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by jack rose on 2017/11/25.
 */
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    CommonService commonService;



    /** JAX-WS **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/CommonService");
        return endpoint;
    }

}
