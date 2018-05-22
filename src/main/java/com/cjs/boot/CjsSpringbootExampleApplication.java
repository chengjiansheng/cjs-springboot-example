package com.cjs.boot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.cjs.boot.event.BlackListListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

//@MapperScan("com.cjs.boot.mapper")
@EnableCaching
@EnableAsync
@SpringBootApplication
public class CjsSpringbootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CjsSpringbootExampleApplication.class, args);

//		SpringApplication springApplication = new SpringApplication(CjsSpringbootExampleApplication.class);
//		springApplication.addListeners(new BlackListListener());
//		springApplication.run(args);

	}

	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new ErrorPageRegistrar() {
			@Override
			public void registerErrorPages(ErrorPageRegistry registry) {
				registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html"));
				registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403.html"));
				registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
				registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
			}
		};
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

		return new HttpMessageConverters(fastJsonHttpMessageConverter);

	}

}
