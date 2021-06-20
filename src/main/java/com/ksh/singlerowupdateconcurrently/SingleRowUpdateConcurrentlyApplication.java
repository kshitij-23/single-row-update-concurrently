package com.ksh.singlerowupdateconcurrently;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SingleRowUpdateConcurrentlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleRowUpdateConcurrentlyApplication.class, args);
	}

}
