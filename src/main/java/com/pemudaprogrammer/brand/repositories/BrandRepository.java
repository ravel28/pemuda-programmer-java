package com.pemudaprogrammer.brand.repositories;

import com.pemudaprogrammer.brand.entities.BrandsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository <BrandsEntity, Integer > {
}
