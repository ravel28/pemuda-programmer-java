package com.pemudaprogrammer.stock_management.supplier.supplierList.controllers;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import com.pemudaprogrammer.stock_management.supplier.supplierList.dtos.CreateUpdateSupplierDto;
import com.pemudaprogrammer.stock_management.supplier.supplierList.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController (SupplierService supplierService){
        this.supplierService = supplierService;
    }


    @PostMapping()
    public ResponseEntity<?> createSupplier(@RequestBody CreateUpdateSupplierDto createSupplier) {
        return new ApiResponseEntity<>(supplierService.createSupplier(createSupplier))
                .toResponseCreated();
    }

    @GetMapping()
    public ResponseEntity<?> listSuppliers(@ModelAttribute FilterPaginationDto paginationDto){
        paginationDto.setCurrent_page(paginationDto.getCurrent_page() - 1);
        return new ApiResponseEntity<>(supplierService.getDataSupplier(paginationDto)).toResponseOk();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Integer id,  @RequestBody CreateUpdateSupplierDto updateSupplierDto) {
        return new ApiResponseEntity<>(supplierService.updateDataSupplier(id, updateSupplierDto)).toResponseOk();
    }
}
