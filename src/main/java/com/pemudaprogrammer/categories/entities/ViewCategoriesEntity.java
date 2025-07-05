package com.pemudaprogrammer.categories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "view_categories", schema = "public")
public class ViewCategoriesEntity {
    @Id
    @Column(name = "id_category")
    private Integer id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "total_items")
    private Integer total_items;
}
