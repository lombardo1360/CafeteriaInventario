package com.cafeteria.cafeteria;


import com.cafeteria.cafeteria.models.Products;
import com.cafeteria.cafeteria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CafeteriaApplication  {


	public static void main(String[] args) {
		SpringApplication.run(CafeteriaApplication.class, args);
	}

}
