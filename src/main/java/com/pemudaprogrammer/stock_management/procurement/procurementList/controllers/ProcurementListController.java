package com.pemudaprogrammer.stock_management.procurement.procurementList.controllers;

import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import com.pemudaprogrammer.product_list.brands.brandList.dtos.CreateUpdateBrandDto;
import com.pemudaprogrammer.stock_management.procurement.procurementList.dtos.CreateUpdateProcurementDto;
import com.pemudaprogrammer.stock_management.procurement.procurementList.services.ProcurementListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("procurement")
public class ProcurementListController {
    private final ProcurementListService procurementListService;

    @Autowired
    public ProcurementListController (ProcurementListService procurementListService){
        this.procurementListService = procurementListService;
    }

    @PostMapping()
    public ResponseEntity<?> createBrand(@RequestBody CreateUpdateProcurementDto createDto) {
        return new ApiResponseEntity<>(procurementListService.createDataProcurement(createDto))
                .toResponseCreated();
    }
}
