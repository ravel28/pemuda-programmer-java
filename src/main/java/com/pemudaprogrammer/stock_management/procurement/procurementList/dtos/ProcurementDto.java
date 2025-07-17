package com.pemudaprogrammer.stock_management.procurement.procurementList.dtos;

import java.time.LocalDate;

import com.pemudaprogrammer.stock_management.supplier.entities.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProcurementDto {
    private Integer id;
    private LocalDate requiredDate;
    private Integer supplierId;
    private Float totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String currency;
    private String description;
    private String paymentMethod;
    private String paymentStatus;
    private String procurementNumber;
    private String procurementType;
    private String status;
    private String title;
    private SupplierEntity supplierEntity;
}