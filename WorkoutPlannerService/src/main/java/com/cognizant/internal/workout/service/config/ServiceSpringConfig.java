package com.cognizant.internal.workout.service.config;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableScheduling
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan({"com.cognizant.internal.workout.service"})
public class ServiceSpringConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Enable Swagger 2
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry theRegistry) {
		theRegistry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources");
		theRegistry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	/**
     * RestClient Bean definition
     * @return RestTemplate
     */
    @Bean
    public RestTemplate getRestClient() {
        return new RestTemplate();
    }

	/**
	 * Conversion of JSON message
	 */
	@Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }
	
	
	/**
	 * 
	 * @return Message Resource Bundles
	 */
	@Bean(name = "externalMessageSource")
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/resource/application");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
