package com.eric.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class will replace web.xml and it will map the spring’s dispatcher servlet and bootstrap it.
 * 使用此設定以取代Web.xml
 * @author yung.ho
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null; //這邊以後可以根據不同的路徑設定
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; //所有路徑都受管
	}
}
