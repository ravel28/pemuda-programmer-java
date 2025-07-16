package com.pemudaprogrammer.product_list.items.itemlist.dtos;

import lombok.Data;

@Data
public class ItemDto {
    private Integer id;
    private String name;
    private String brand;
    private Integer kategory_id;
}
