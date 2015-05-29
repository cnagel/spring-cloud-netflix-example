package cnagel.spring_cloud_example.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);
	}

}
