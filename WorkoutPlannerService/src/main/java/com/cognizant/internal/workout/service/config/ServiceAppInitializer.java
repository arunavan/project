package com.cognizant.internal.workout.service.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.cognizant.internal.workout.service.constant.ServiceConstant;
/**
 * ServiceAppInitializer is used to perform activity during server startup
 */
@Configuration
public class ServiceAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext inContainer) throws ServletException {
		System.setProperty(ServiceConstant.APP_DEPLOYMENT_LEVEL, "DVL");
		// Initialize Logger
		final StringBuilder theBuffer =  new StringBuilder(256);
		theBuffer.append("/config/");
		theBuffer.append(System.getProperty(ServiceConstant.APP_DEPLOYMENT_LEVEL).toLowerCase());		
		theBuffer.append("log4j2.xml");
		Configurator.initialize("WorkoutService", theBuffer.toString());
		// Registering Service Configuration
		final AnnotationConfigWebApplicationContext theServiceContext = new AnnotationConfigWebApplicationContext();
		theServiceContext.register(ServiceSpringConfig.class);
		final ServletRegistration.Dynamic theServletRegistration = inContainer.addServlet("dispatcher",
				new DispatcherServlet(theServiceContext));
		theServletRegistration.setLoadOnStartup(1);
		theServletRegistration.addMapping("/");
		Logger theLogger = LoggerFactory.getLogger(this.getClass());
		theLogger.info("WorkOut Service App Initialized Successfully....");
	}

}
