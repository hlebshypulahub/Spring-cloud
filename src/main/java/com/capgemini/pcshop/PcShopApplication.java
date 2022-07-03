package com.capgemini.pcshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PcShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcShopApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//		return args -> {
//			kafkaTemplate.send("pcshop", "Hello Kafka");
//		};
//	}

}
