package cnagel.spring_cloud_example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cnagel.spring_cloud_example.commons.HelloWorld;
import cnagel.spring_cloud_example.consumer.Application.HelloWorldClient;

@RestController
public class SimpleController {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand
	@RequestMapping("/rest/{name}")
	public HelloWorld rest(@PathVariable("name") final String name) {
		return restTemplate.getForObject("http://producer/hello/" + name,
				HelloWorld.class);
	}

	@Autowired
	private HelloWorldClient client;

	@HystrixCommand
	@RequestMapping("/feign/{name}")
	public HelloWorld feign(@PathVariable("name") final String name) {
		return client.hello(name);
	}

}
