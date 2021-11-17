package org.example;

import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.example.service.UserServiceImpl;

public class Server {
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setAddress("http://localhost:8082/rs");
        factoryBean.setServiceBean(new UserServiceImpl());
        factoryBean.getInInterceptors().add(new LoggingOutInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.create();
        System.out.println("发布服务成功");
    }
}
