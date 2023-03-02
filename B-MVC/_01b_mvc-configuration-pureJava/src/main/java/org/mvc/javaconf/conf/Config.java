package org.mvc.javaconf.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//replaces the servlet-conf.xml
@Configuration
@EnableWebMvc                                       // replaces <mvc:annotation-driven/> in xml
@ComponentScan(basePackages = "org.mvc.javaconf")   // replaces <context:component-scan base-package="org.mvc.conf" /> in xml
public class Config {

    // replaces
    //        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    //          <property name="prefix" value="/WEB-INF/views/" />
    //          <property name="suffix" value=".jsp" />
    //        </bean>
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
