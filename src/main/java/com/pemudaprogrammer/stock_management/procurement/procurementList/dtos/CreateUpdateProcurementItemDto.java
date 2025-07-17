package com.pemudaprogrammer.stock_management.procurement.procurementList.dtos;

import lombok.Data;

@Data
public class CreateUpdateProcurementItemDto {
    private Float price;
    private Integer qty;
    private Integer itemId;
}
