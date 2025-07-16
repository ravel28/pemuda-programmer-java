package com.pemudaprogrammer.product_list.categories.repositories;

import com.pemudaprogrammer.product_list.categories.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Integer> {
}
