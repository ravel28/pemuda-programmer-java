package com.pemudaprogrammer.product_list.items.itemlist.dtos;

import lombok.Data;

@Data
public class CreateUpdateItemDto {
    private Integer id;
    private String item_name;
    private Integer brand_id;
    private Integer category_id;
}
