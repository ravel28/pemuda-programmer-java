package com.pemudaprogrammer.product_list.brands.brandList.controllers;

import com.pemudaprogrammer.product_list.brands.brandList.dtos.CreateUpdateBrandDto;
import com.pemudaprogrammer.product_list.brands.brandList.services.BrandService;
import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brand")
public class BrandListControllers {
    private final BrandService brandService;

    @Autowired
    public BrandListControllers(
            BrandService brandService
            ){
        this.brandService = brandService;
    }

    @PostMapping()
    public ResponseEntity<?> createBrand(@RequestBody CreateUpdateBrandDto createBrand) {
        return new ApiResponseEntity<>(brandService.createBrand(createBrand))
                .toResponseCreated();
    }

    @GetMapping()
    public ResponseEntity<?> listBrand(@ModelAttribute FilterPaginationDto paginationDto){
        paginationDto.setCurrent_page(paginationDto.getCurrent_page() - 1);
        return new ApiResponseEntity<>(brandService.getList(paginationDto)).toResponseOk();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Integer id,  @RequestBody CreateUpdateBrandDto updateBrandDto) {
        return new ApiResponseEntity<>(brandService.updateBrand(id, updateBrandDto)).toResponseOk();
    }

}
