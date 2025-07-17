package com.pemudaprogrammer.stock_management.procurement.procurementList.dtos;

import com.pemudaprogrammer.stock_management.supplier.entities.SupplierEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateUpdateProcurementDto {
    private LocalDate requiredDate;
    private String title;
    private String description;
    private String paymentMethod;
    private String paymentStatus;
    private String procurementNumber;
    private String procurementType;
    private String currency;
    private Float totalAmount;
    private Integer supplierId;
    private Integer userId;
    private List<CreateUpdateProcurementItemDto> createUpdateProcurementItemDto;
}
