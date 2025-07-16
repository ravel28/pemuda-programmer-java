package com.pemudaprogrammer.stock_management.procurement.entities;

import com.pemudaprogrammer.supplier.entities.SupplierEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "procurement", schema = "public")
public class ProcurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "procurement_number", nullable = false, unique = true)
    private String procurement_number;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name= "status", nullable = false)
    private String status;

    @Column(name = "total_amount", nullable = false)
    private Float totalAmount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "procurement_type")
    private String procurementType;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierEntity supplierEntity;
}
