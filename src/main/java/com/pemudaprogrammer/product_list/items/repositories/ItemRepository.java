package com.pemudaprogrammer.product_list.items.repositories;

import com.pemudaprogrammer.product_list.items.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
