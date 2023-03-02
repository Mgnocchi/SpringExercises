package org.mvc.javaconf.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// This replaces the web.xml
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // replaces:
    //     <servlet>
    //        ...
    //        <init-param>
    //            <param-name>contextConfigLocation</param-name>
    //            <param-value>/servlet-conf.xml</param-value>
    //        </init-param>
    //        ...
    //    </servlet>
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                Config.class
        };
    }

    // replaces:
    //      <servlet-mapping>
    //          <servlet-name>dispatcher</servlet-name>
    //          <url-pattern>/</url-pattern>
    //      </servlet-mapping>
    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
}
