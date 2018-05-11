package com.cjs.boot;

import com.cjs.boot.event.BlackListListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;

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

}
