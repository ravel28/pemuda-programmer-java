package com.pemudaprogrammer.stock_management.procurement.entities;

import com.pemudaprogrammer.stock_management.supplier.entities.SupplierEntity;
import com.pemudaprogrammer.users.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
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

    @CreationTimestamp
    @Column(name= "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name= "updated_at", nullable = false)
    private Date updated_at;

    @OneToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierEntity supplierEntity;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity userEntity;
}
