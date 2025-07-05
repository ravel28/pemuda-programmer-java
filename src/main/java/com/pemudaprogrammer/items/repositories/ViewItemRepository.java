package com.pemudaprogrammer.items.repositories;

import com.pemudaprogrammer.items.entities.ViewItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewItemRepository extends JpaRepository <ViewItemEntity, Integer> {
}
