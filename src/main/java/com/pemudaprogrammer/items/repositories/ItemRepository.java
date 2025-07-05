package com.pemudaprogrammer.items.repositories;

import com.pemudaprogrammer.items.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
