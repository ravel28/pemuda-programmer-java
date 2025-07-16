package com.pemudaprogrammer.supplier.supplierList.dtos;

import lombok.Data;

@Data
public class SupplierDto {
    private Integer id;
    private String contact_email;
    private String contact_person;
    private String contact_person_name;
    private String supplier_address;
    private String supplier_name;
}