package com.pemudaprogrammer.stock_management.supplier.supplierList.services;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.stock_management.supplier.entities.SupplierEntity;
import com.pemudaprogrammer.stock_management.supplier.repositories.SupplierRepository;
import com.pemudaprogrammer.stock_management.supplier.supplierList.dtos.CreateUpdateSupplierDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired()
    public SupplierService (SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity createSupplier (CreateUpdateSupplierDto createSupplier){
        SupplierEntity supplier = new SupplierEntity();
        supplier.setSupplier_name(createSupplier.getSupplier_name());
        supplier.setSupplier_addresss(createSupplier.getSupplier_address());
        supplier.setContact_email(createSupplier.getContact_email());
        supplier.setContact_person(createSupplier.getContact_person());
        supplier.setContact_person_name(createSupplier.getContact_person_name());
        return supplierRepository.save(supplier);
    }

    public List<SupplierEntity> getDataSupplier (FilterPaginationDto filterPaginationDto){
        Pageable pageable = PageRequest.of(filterPaginationDto.getCurrent_page(), filterPaginationDto.getTake());
        Page<SupplierEntity> pageResult = supplierRepository.findAll(pageable);
        return pageResult.getContent();
    }

    public SupplierEntity updateDataSupplier(Integer id, CreateUpdateSupplierDto updateSupplier){
        SupplierEntity findSupplier = supplierRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));

        findSupplier.setSupplier_name(updateSupplier.getSupplier_name());
        findSupplier.setSupplier_addresss(updateSupplier.getSupplier_address());
        findSupplier.setContact_email(updateSupplier.getContact_email());
        findSupplier.setContact_person(updateSupplier.getContact_person());
        findSupplier.setContact_person_name(updateSupplier.getContact_person_name());
        return supplierRepository.save(findSupplier);
    }
}
