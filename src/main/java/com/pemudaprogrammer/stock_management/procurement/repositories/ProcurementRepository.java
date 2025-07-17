package com.pemudaprogrammer.stock_management.procurement.repositories;

import com.pemudaprogrammer.stock_management.procurement.entities.ProcurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementRepository extends JpaRepository<ProcurementEntity, Integer> {
}
