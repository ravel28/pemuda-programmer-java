package com.pemudaprogrammer.items.itemlist.controllers;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import com.pemudaprogrammer.categories.categorylist.dtos.CreateUpdateCategoryDto;
import com.pemudaprogrammer.items.itemlist.dtos.CreateUpdateItemDto;
import com.pemudaprogrammer.brand.brandList.services.BrandService;
import com.pemudaprogrammer.categories.categorylist.services.CategoryService;
import com.pemudaprogrammer.items.itemlist.services.ItemListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemListControllers {
    private final ItemListService itemListService;
    private final CategoryService categoryService;

    @Autowired
    public ItemListControllers(
            ItemListService itemListService,
            BrandService brandService,
            CategoryService categoryService
            ){
        this.itemListService = itemListService;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody CreateUpdateItemDto createItem) {
        return new ApiResponseEntity<>(itemListService.createItem(createItem))
                .toResponseCreated();
    }

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CreateUpdateCategoryDto categoryDto) {
        return new ApiResponseEntity<>(categoryService.createCategory(categoryDto))
                .toResponseCreated();
    }

    @GetMapping("list")
    public ResponseEntity<?> getUsersList(@Valid @ModelAttribute FilterPaginationDto filterPaginationDto){
        filterPaginationDto.setCurrent_page(filterPaginationDto.getCurrent_page() - 1);
        return new ApiResponseEntity<>(itemListService.getListItems(filterPaginationDto)).toResponseOk();
    }

}
