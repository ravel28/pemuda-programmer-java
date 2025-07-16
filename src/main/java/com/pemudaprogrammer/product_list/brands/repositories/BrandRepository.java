package com.pemudaprogrammer.product_list.brands.repositories;

import com.pemudaprogrammer.product_list.brands.entities.BrandsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository <BrandsEntity, Integer > {
}
