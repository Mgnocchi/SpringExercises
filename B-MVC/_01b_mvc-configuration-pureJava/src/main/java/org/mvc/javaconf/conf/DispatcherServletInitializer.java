package org.mvc.javaconf.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// This replaces the web.xml

/**
 * This class implements WebApplicationInitializer through inheritance and automatically implements a more streamlined
 * .onStartup method, compared to the example below. I have no idea about pro or cons.
 *
 * This means that this class too doesn't need annotations and is bootstrapped by the servlet
 */
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

// Alternative way to do this:
/**
 * Notice how this class is not annotated using Spring annotations: This is bootstrapped by any servlet
 */
//public class SpringWebAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        appContext.register(MvcConfig.class);
//
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
//                "SpringDispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//
//    }
//
//}
