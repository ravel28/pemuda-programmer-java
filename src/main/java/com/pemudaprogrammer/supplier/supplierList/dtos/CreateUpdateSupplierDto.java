package com.pemudaprogrammer.supplier.supplierList.dtos;

import lombok.Data;

@Data
public class CreateUpdateSupplierDto {
    private String contact_email;
    private String contact_person;
    private String contact_person_name;
    private String supplier_address;
    private String supplier_name;
}
