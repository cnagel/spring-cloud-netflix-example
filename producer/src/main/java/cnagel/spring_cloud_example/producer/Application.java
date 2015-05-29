package cnagel.spring_cloud_example.producer;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnagel.spring_cloud_example.commons.HelloWorld;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("hello/{name}")
	public HelloWorld hello(@PathVariable("name") final String name) {
		HelloWorld model = new HelloWorld();
		model.date = new Date();
		model.name = name;
		return model;
	}

}