package com.dengzhihong.config;

import com.dengzhihong.controller.interceptor.ProjectInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * 在这里不需要了，SpringMvc_Config已经继承了WebMvcConfigurer
 */
//@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Autowired
    private ProjectInterception projectInterception;
    /**
     * 设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/????时候，从/pages目录下查找内容
        registry.addResourceHandler("/pages/**")
                .addResourceLocations("/pages/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/");

        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");

        registry.addResourceHandler("/plugins/**")
                .addResourceLocations("/plugins/");
    }

    /**
     * 注册mvc请求拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterception).addPathPatterns("/books","/books/*");
    }
}
