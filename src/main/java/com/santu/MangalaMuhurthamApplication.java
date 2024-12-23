package com.santu;

import com.santu.util.DotenvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MangalaMuhurthamApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MangalaMuhurthamApplication.class);
		application.addInitializers(new DotenvLoader());
		application.run(args);
//		SpringApplication.run(MangalaMuhurthamApplication.class, args);
	}

}
