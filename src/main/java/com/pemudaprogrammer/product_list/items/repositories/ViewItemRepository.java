package com.pemudaprogrammer.product_list.items.repositories;

import com.pemudaprogrammer.product_list.items.entities.ViewItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewItemRepository extends JpaRepository <ViewItemEntity, Integer> {
}
