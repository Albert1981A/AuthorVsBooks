package com.AlbertAbuav.AuthorVsBooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication  // ==> @Configuration + @ComponentScan(basePackages = "com.AlbertAbuav.AuthorVsBooks") + @EnableAutoConfiguration + @Conditional
public class AuthorVsBooksApplication {

	public static void main(String[] args) {

		/**
		 * Web Service
		 * 1. Purpose - What to do (get object, insert object... )
		 * 2. URL - Uniform Resource Locator
		 * 3. Verb - POST / GET / PUT / DELETE  (CRUD)
		 *
		 * REST - Representational State Transfer
		 * 1.A standard (protocol) for managing resources
		 *   Between server and server or server and client.
		 * 2.Uses the HTTP communication protocol by reaching a
		 *   URL along with a characterization for a required
		 *   Action called Verb.
		 */

		ApplicationContext ctx = SpringApplication.run(AuthorVsBooksApplication.class, args);
		System.out.println("Spring Ioc container was loaded!");


	}

}
