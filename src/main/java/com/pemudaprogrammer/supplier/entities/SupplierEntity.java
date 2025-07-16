package com.pemudaprogrammer.supplier.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supplier", schema="public")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "supplier_name", nullable = false)
    private String supplier_name;

    @Column(name= "supplier_address", nullable = false)
    private String supplier_addresss;

    @Column(name = "contact_person", nullable = false)
    private String contact_person;

    @Column(name= "contact_person_name", nullable = false)
    private String contact_person_name;

    @Column(name = "contact_email")
    private String contact_email;
}
