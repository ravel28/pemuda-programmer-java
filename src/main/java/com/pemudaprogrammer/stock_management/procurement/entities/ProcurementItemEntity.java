package com.pemudaprogrammer.stock_management.procurement.entities;

import com.pemudaprogrammer.product_list.items.entities.ItemEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@Builder
@Table(name = "procurement_item")
public class ProcurementItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "procurement_id", nullable = false)
    ProcurementEntity procurementEntity;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemEntity itemEntity;

    @CreationTimestamp
    @Column(name= "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name= "updated_at", nullable = false)
    private Date updated_at;
}
