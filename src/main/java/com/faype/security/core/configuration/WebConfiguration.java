package com.faype.security.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Configuration
@ComponentScan({
        "com.faype.security.resource",
        "com.faype.security.core"
})
public class WebConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    private AbstractApplicationContext context;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }


}
