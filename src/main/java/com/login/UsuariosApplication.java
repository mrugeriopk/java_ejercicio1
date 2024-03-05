package com.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;

@SpringBootApplication
public class UsuariosApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsuariosApplication.class, args);
		System.out.println("Version de Java: "+ JavaVersion.getJavaVersion());
	}

}
