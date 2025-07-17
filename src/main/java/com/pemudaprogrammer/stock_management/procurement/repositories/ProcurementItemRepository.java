package com.pemudaprogrammer.stock_management.procurement.repositories;

import com.pemudaprogrammer.stock_management.procurement.entities.ProcurementItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementItemRepository extends JpaRepository<ProcurementItemEntity, Integer> {
}
