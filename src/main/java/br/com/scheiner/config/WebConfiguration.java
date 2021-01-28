package br.com.scheiner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "swagger-ui.html");
    }
    
    
	/*
	 * @Configuration
	 * 
	 * @EnableWebMvc public class WebMvcConfig extends WebMvcConfigurerAdapter {
	 * 
	 * @Override public void addResourceHandlers(final ResourceHandlerRegistry
	 * registry) {
	 * 
	 * registry.addResourceHandler("swagger-ui.html")
	 * .addResourceLocations("classpath:/META-INF/resources/");
	 * 
	 * registry.addResourceHandler("/webjars/**")
	 * .addResourceLocations("classpath:/META-INF/resources/webjars/"); }
	 * 
	 * 
	 * }
	 */

}