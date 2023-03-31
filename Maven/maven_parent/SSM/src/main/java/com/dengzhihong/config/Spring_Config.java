package com.dengzhihong.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.dengzhihong.service"})
@PropertySource("classpath:jdbc.properties")
@Import({Jdbc_Config.class,Mybatis_Config.class})
@EnableTransactionManagement
public class Spring_Config {
}
