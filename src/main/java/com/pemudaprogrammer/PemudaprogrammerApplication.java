package com.pemudaprogrammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
		"com.pemudaprogrammer.items.entities",
		"com.pemudaprogrammer.brand.entities",
		"com.pemudaprogrammer.categories.entities",
		"com.pemudaprogrammer.users.entities"
})
public class PemudaprogrammerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PemudaprogrammerApplication.class, args);
	}

}
