package org.springframework.samples.mvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initialize the Servlet container. This class is detected by the Servlet
 * container on startup.
 */
public class MvcShowcaseAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	//csrf 보안적용 시 post 요청하면 403에러나 발생하여 임시로 csrf적용안함. 
	/*
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new DelegatingFilterProxy("csrfFilter") };
	}
	 */
}
