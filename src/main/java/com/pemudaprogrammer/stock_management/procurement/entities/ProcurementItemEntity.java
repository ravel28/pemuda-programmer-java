package com.pemudaprogrammer.stock_management.procurement.entities;

import com.pemudaprogrammer.product_list.items.entities.ItemEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "procurement_item")
public class ProcurementItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "procurement_id", nullable = false)
    ProcurementEntity procurementEntity;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemEntity itemEntity;
}
