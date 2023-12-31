package com.app.pillars;

import com.app.pillars.configure.audit.Auditor;
import com.app.pillars.configure.swagger.OpenAPIConfig;
import com.app.pillars.util.DBConnection;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditor")
public class PillarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PillarsApplication.class, args);

	}

//	@Bean
//	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//	public DBConnection singletonBean() {
//		return new DBConnection();
//	}
@Bean
public AuditorAware<Integer> auditor() {
	return new Auditor();
}

}
