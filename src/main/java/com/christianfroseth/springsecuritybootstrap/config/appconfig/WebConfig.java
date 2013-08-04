package com.christianfroseth.springsecuritybootstrap.config.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Configuration for WebContext
 * User: Christian Froseth
 * Date: 8/4/13
 * Time: 12:41 AM
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.christianfroseth.springsecuritybootstrap.*")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Create request mapping bean for @RequestMapping
     *
     * @return RequestMappingHandlerMapping
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    /**
     * Override servlet handling to allow static resources
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}