package com.pemudaprogrammer.stock_management.outbond.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "outbond_item", schema = "public")
public class OutbondItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "outbond_id")
    private OutbondEntity outbondEntity;
}
