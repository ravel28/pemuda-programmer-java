package com.pemudaprogrammer.product_list.items.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "view_items", schema = "public")
public class ViewItemEntity {
    @Id
    @Column(name = "id_item")
    private Integer id_item;

    @Column(name = "item_name")
    private String item_name;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "brand_name")
    private String brand_name;
}
