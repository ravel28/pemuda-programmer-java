package com.pemudaprogrammer.product_list.categories.categorylist.controllers;

import com.pemudaprogrammer.product_list.categories.categorylist.dtos.CreateUpdateCategoryDto;
import com.pemudaprogrammer.product_list.categories.categorylist.services.CategoryService;
import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryListControllers {
    private final CategoryService categoryService;

    @Autowired
    public CategoryListControllers(
            CategoryService categoryService
            ){
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody CreateUpdateCategoryDto categoryDto) {
        return new ApiResponseEntity<>(categoryService.createCategory(categoryDto))
                .toResponseCreated();
    }

    @GetMapping()
    public ResponseEntity<?> listCategory(@ModelAttribute FilterPaginationDto filterPaginationDto) {
        filterPaginationDto.setCurrent_page(filterPaginationDto.getCurrent_page() -1);
        return new ApiResponseEntity<>(categoryService.getList(filterPaginationDto)).toResponseOk();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CreateUpdateCategoryDto updateCategoryDto) {
        return new ApiResponseEntity<>(categoryService.updateCategory(id, updateCategoryDto)).toResponseOk();
    }

}
