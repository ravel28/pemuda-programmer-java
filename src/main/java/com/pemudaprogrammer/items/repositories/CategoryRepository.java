package com.pemudaprogrammer.items.repositories;

import com.pemudaprogrammer.items.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoriesEntity, Integer> {
}
