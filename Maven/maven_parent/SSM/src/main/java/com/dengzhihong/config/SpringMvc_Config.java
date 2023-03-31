package com.dengzhihong.config;


import com.dengzhihong.controller.interceptor.ProjectInterception;
import com.dengzhihong.controller.interceptor.ProjectInterception2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.dengzhihong.controller"})
@EnableWebMvc
/**
 * 实现WebMvcConfigurer接口可以简化开发，但具有一定的侵入性
 */
public class SpringMvc_Config implements WebMvcConfigurer {
    @Autowired
    private ProjectInterception projectInterception;

    @Autowired
    private ProjectInterception2 projectInterception2;

    /**
     * 设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
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
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterception).addPathPatterns("/books","/books/*");
        registry.addInterceptor(projectInterception2).addPathPatterns("/books","/books/*");
    }
}
