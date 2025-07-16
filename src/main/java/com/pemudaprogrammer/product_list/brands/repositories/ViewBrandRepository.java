package com.pemudaprogrammer.product_list.brands.repositories;

import com.pemudaprogrammer.product_list.brands.entities.ViewBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewBrandRepository extends JpaRepository <ViewBrandEntity, Integer> {
}
