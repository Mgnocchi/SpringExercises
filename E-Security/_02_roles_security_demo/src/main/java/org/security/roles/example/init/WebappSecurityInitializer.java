package org.security.roles.example.init;

import org.security.roles.example.conf.MainConfigClass;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebappSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    // we just override the empty constructor giving it a list of the configuration classes to delegate them to super
    public WebappSecurityInitializer() {
        super(MainConfigClass.class);
    }
}
