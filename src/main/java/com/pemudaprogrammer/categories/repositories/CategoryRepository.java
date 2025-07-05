package com.pemudaprogrammer.categories.repositories;

import com.pemudaprogrammer.categories.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoriesEntity, Integer> {
}
