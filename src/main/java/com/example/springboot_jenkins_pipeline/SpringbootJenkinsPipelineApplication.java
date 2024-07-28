package com.example.springboot_jenkins_pipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/jenkins")
public class SpringbootJenkinsPipelineApplication {

	@RequestMapping("/message")
	public String getMessage() {
		return "Welcome to Jenkins Pipeline. If you see this message, it means that the Jenkins Pipeline is working fine.";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJenkinsPipelineApplication.class, args);
	}

}
