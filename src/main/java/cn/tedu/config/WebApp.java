package cn.tedu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.Filter;
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new CharacterEncodingFilter("UTF-8")};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {Config.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"*.do"};
    }
}
