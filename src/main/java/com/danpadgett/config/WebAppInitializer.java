package com.danpadgett.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext();
		
		ContextLoaderListener listener = new ContextLoaderListener(context);
		servletContext.addListener(listener);
		
//		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		DispatcherServlet dispacherServler = new DispatcherServlet(context);
		ServletRegistration.Dynamic dispacher = servletContext.addServlet("DispatcherServlet", dispacherServler);
		
//		<load-on-startup>1</load-on-startup>
		dispacher.setLoadOnStartup(1);
		
//		<servlet-mapping>
//			<servlet-name>springDispatcherServlet</servlet-name>
//			<url-pattern>/</url-pattern>
//		</servlet-mapping
		dispacher.addMapping("/");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		
//		<init-param>
//			<param-name>contextClass</param-name>
//			<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
//		</init-param>
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		
//		<init-param>
//			<param-name>contextConfigLocation</param-name>
//			<param-value>com.danpadgett.WebConfig</param-value>
//		</init-param>
		context.setConfigLocation("com.danpadgett.config.WebConfig");
		
		return context;
	}
}
