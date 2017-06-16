//package com.scy.mall.config;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletRegistration;
//
///**
// * Created by Shichengyao on 2017/6/16.
// */
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext container) {
//        ServletRegistration.Dynamic registration = container.addServlet("example", new DispatcherServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/*.do");
//    }
//
//}