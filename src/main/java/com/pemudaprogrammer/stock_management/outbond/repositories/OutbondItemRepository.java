package com.pemudaprogrammer.stock_management.outbond.repositories;

import com.pemudaprogrammer.stock_management.outbond.entities.OutbondEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutbondItemRepository extends JpaRepository<OutbondEntity, Integer> {
}
