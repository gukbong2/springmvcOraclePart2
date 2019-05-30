package org.zerock.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = { "org.zerock.controller", "org.zerock.exception"})
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		//한번의 Request의 용량 10MB 제한
		resolver.setMaxUploadSize(1024 * 1024 * 10);
		
		//파일 1개당 2MB 제한
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
		
		//메모리상에서 유지하는 최대의 크기
		resolver.setMaxInMemorySize(1024 * 1024);
		
		//임시저장 경로
		resolver.setUploadTempDir(new FileSystemResource("E:\\upload\\tmp"));
		
		//UTF-8 엔코딩 타입
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;
		
		
	}
}
