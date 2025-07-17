package com.pemudaprogrammer.users.positions.positionList.controllers;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import com.pemudaprogrammer.users.positions.positionList.dtos.CreateUpdatePositionDto;
import com.pemudaprogrammer.users.positions.positionList.services.PositionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("position")
public class PositionController {
    private final PositionListService positionListService;

    @Autowired
    public PositionController (PositionListService positionListService){
        this.positionListService = positionListService;
    }


    @PostMapping()
    public ResponseEntity<?> createBrand(@RequestBody CreateUpdatePositionDto createPositionDto) {
        return new ApiResponseEntity<>(positionListService.createPosition(createPositionDto))
                .toResponseCreated();
    }

    @GetMapping()
    public ResponseEntity<?> listBrand(@ModelAttribute FilterPaginationDto paginationDto){
        paginationDto.setCurrent_page(paginationDto.getCurrent_page() - 1);
        return new ApiResponseEntity<>(positionListService.getPosition(paginationDto)).toResponseOk();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Integer id,  @RequestBody CreateUpdatePositionDto updatePositionDto) {
        return new ApiResponseEntity<>(positionListService.updatePositionName(id, updatePositionDto)).toResponseOk();
    }

}
