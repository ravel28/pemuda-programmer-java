package com.pemudaprogrammer.product_list.items.entities;

import com.pemudaprogrammer.product_list.brands.entities.BrandsEntity;
import com.pemudaprogrammer.product_list.categories.entities.CategoriesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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

    @CreationTimestamp
    @Column(name= "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name= "updated_at", nullable = false)
    private Date updated_at;

}
