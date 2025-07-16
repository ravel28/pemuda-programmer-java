package com.pemudaprogrammer.product_list.brands.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "view_brand", schema = "public")
public class ViewBrandEntity {
    @Id
    @Column(name = "id_brand")
    private Integer id;

    @Column(name = "brand_name")
    private String brand_name;

    @Column(name = "total_items")
    private Integer total_items;
}
