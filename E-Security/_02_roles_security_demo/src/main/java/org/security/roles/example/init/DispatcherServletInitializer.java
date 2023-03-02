package org.security.roles.example.init;

import org.security.roles.example.conf.MainConfigClass;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// This replaces the web.xml
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                MainConfigClass.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
}
