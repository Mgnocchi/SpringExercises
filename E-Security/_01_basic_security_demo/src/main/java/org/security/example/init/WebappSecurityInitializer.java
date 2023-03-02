package org.security.example.init;

import org.security.example.conf.MainConfigClass;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebappSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    // we just override the empty constructor giving it a list of the configuration classes to delegate them to super
    public WebappSecurityInitializer() {
        super(MainConfigClass.class);
    }
}
