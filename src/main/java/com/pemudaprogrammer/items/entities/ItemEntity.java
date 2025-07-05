package com.pemudaprogrammer.items.entities;

import com.pemudaprogrammer.brand.entities.BrandsEntity;
import com.pemudaprogrammer.categories.entities.CategoriesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "items", schema = "public")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name", nullable = false)
    private String item_name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    BrandsEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    CategoriesEntity categoryEntity;

}
