package com.pemudaprogrammer.stock_management.supplier.repositories;

import com.pemudaprogrammer.stock_management.supplier.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}
