package com.pemudaprogrammer.brand.repositories;

import com.pemudaprogrammer.brand.entities.ViewBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewBrandRepository extends JpaRepository <ViewBrandEntity, Integer> {
}
