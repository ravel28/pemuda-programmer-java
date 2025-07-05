package com.pemudaprogrammer.brand.brandList.services;

import com.pemudaprogrammer.brand.entities.BrandsEntity;
import com.pemudaprogrammer.brand.brandList.dtos.CreateUpdateBrandDto;
import com.pemudaprogrammer.brand.entities.ViewBrandEntity;
import com.pemudaprogrammer.brand.repositories.BrandRepository;
import com.pemudaprogrammer.brand.repositories.ViewBrandRepository;
import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class BrandService {
    final private BrandRepository brandRepository;
    final private ViewBrandRepository viewBrandRepository;

    @Autowired
    public BrandService (BrandRepository brandRepository, ViewBrandRepository viewBrandRepository){
        this.brandRepository = brandRepository;
        this.viewBrandRepository = viewBrandRepository;
    }

    public BrandsEntity createBrand(CreateUpdateBrandDto createBrandDto){
        BrandsEntity save_data = new BrandsEntity();
        save_data.setName_brand(createBrandDto.getBrand_name());
        return brandRepository.save(save_data);
    }

    public List<ViewBrandEntity> getList(FilterPaginationDto filterPaginationDto) {
        Pageable pageable = PageRequest.of(filterPaginationDto.getCurrent_page(), filterPaginationDto.getTake());
        Page<ViewBrandEntity> pageResult = viewBrandRepository.findAll(pageable);
        return pageResult.getContent();
    }

    public BrandsEntity updateBrand(Integer id, CreateUpdateBrandDto createUpdateBrandDto){
        BrandsEntity save_data = brandRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand not found"));
        save_data.setName_brand(createUpdateBrandDto.getBrand_name());
        return brandRepository.save(save_data);
    }
}
