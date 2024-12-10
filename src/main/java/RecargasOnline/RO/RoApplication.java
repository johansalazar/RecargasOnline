package RecargasOnline.RO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoApplication.class, args);
	}
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> customizer() {
		return factory -> factory.setPort(8081);
	}
}
