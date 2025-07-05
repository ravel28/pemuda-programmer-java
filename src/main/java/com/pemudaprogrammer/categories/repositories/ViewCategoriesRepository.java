package com.pemudaprogrammer.categories.repositories;

import com.pemudaprogrammer.categories.entities.ViewCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewCategoriesRepository extends JpaRepository<ViewCategoriesEntity, Integer> {

}
