package com.christianfroseth.springsecuritybootstrap.config.initializers;

import com.christianfroseth.springsecuritybootstrap.config.appconfig.ApplicationConfig;
import com.christianfroseth.springsecuritybootstrap.config.appconfig.WebConfig;
import com.christianfroseth.springsecuritybootstrap.config.securityconfig.WebSecurityConfig;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Boostraps application and load Spring context
 * <p/>
 * User: Christian Froseth
 * Date: 8/4/13
 * Time: 12:40 AM
 */
public class Initializer implements WebApplicationInitializer {

    private static final Logger logger = Logger.getLogger(Initializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.info("Bootstrapping Spring application context");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationConfig.class, WebSecurityConfig.class);

        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
