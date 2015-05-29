package cnagel.spring_cloud_example.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableTurbine
@Controller
public class TurbineApplication {

	@RequestMapping("/")
	public String home() {
		return "forward:/turbine.stream";
	}

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}

}
