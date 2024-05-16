package com.myspring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;

// entweder unkommentiert diese implement und nutz dieses Class
// oder bleib bei applicationInitializerPro Class beides erreichen die gleiche ziel
public class ApplicationInitializer/* implements WebApplicationInitializer*/  {

//	@Override
	public void onStartup(ServletContext  servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("hello from the specific type*****************************************");
		
		// create the context for the servlet
		// if we have the servlet configuration as xml file
//		XmlWebApplicationContext context = new XmlWebApplicationContext() {
//			protected String[] getDefaultConfigLocations() {
//				return new String []  {"beans.xml"};
//			}
//		};
		
		//else if we have the serlet configuration as java class 
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyConfig.class);
		
		// create the dispatcherServlet
		DispatcherServlet disServlet = new DispatcherServlet(context);

		
		Dynamic myCustomDispatcher = servletContext.addServlet("myDispatcherServlet", disServlet);
		myCustomDispatcher.setLoadOnStartup(1);
		myCustomDispatcher.addMapping("/mywebsite.com/*");
		
		
		
		
		
	}

}
