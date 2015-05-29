package cnagel.spring_cloud_example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnagel.spring_cloud_example.commons.HelloWorld;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@FeignClient("producer")
	interface HelloWorldClient {

		@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
		HelloWorld hello(@PathVariable("name") final String name);

	}

}