package com.pemudaprogrammer.stock_management.procurement.procurementList.dtos;

import lombok.Data;

@Data
public class ProcurementItemDto {
    private Integer id;
    private Float price;
    private Integer qty;
    private Integer itemId;
    private Integer procurementId;
}
