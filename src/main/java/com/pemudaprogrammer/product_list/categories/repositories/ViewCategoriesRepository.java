package com.pemudaprogrammer.product_list.categories.repositories;

import com.pemudaprogrammer.product_list.categories.entities.ViewCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewCategoriesRepository extends JpaRepository<ViewCategoriesEntity, Integer> {

}
