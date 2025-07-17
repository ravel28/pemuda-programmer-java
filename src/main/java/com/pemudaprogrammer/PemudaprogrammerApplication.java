package com.pemudaprogrammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
		"com.pemudaprogrammer.product_list.items.entities",
		"com.pemudaprogrammer.product_list.brands.entities",
		"com.pemudaprogrammer.product_list.categories.entities",
		"com.pemudaprogrammer.stock_management.supplier.entities",
		"com.pemudaprogrammer.stock_management.procurement.entities",
		"com.pemudaprogrammer.stock_management.outbond.entities",
		"com.pemudaprogrammer.users.users.entities",
		"com.pemudaprogrammer.users.positions.entities",
})
public class PemudaprogrammerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PemudaprogrammerApplication.class, args);
	}

}
