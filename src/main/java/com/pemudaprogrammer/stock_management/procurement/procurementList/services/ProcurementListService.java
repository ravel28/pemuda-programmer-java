package com.pemudaprogrammer.stock_management.procurement.procurementList.services;

import com.pemudaprogrammer.product_list.items.entities.ItemEntity;
import com.pemudaprogrammer.product_list.items.repositories.ItemRepository;
import com.pemudaprogrammer.stock_management.procurement.entities.ProcurementEntity;
import com.pemudaprogrammer.stock_management.procurement.entities.ProcurementItemEntity;
import com.pemudaprogrammer.stock_management.procurement.procurementList.dtos.CreateUpdateProcurementDto;
import com.pemudaprogrammer.stock_management.procurement.procurementList.dtos.CreateUpdateProcurementItemDto;
import com.pemudaprogrammer.stock_management.procurement.repositories.ProcurementItemRepository;
import com.pemudaprogrammer.stock_management.procurement.repositories.ProcurementRepository;
import com.pemudaprogrammer.stock_management.supplier.entities.SupplierEntity;
import com.pemudaprogrammer.stock_management.supplier.repositories.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class ProcurementListService {
    private final ProcurementRepository procurementRepository;
    private final ProcurementItemRepository procurementItemRepository;
    private final SupplierRepository supplierRepository;
    private final ItemRepository itemRepository;


    @Autowired
    public ProcurementListService (ProcurementRepository procurementRepository, ProcurementItemRepository procurementItemRepository, SupplierRepository supplierRepository, ItemRepository itemRepository){
        this.procurementRepository = procurementRepository;
        this.procurementItemRepository = procurementItemRepository;
        this.supplierRepository = supplierRepository;
        this.itemRepository = itemRepository;
    }

    public ProcurementEntity createDataProcurement (CreateUpdateProcurementDto createProcurement){
        SupplierEntity supplierEntity = this.supplierRepository.findById(createProcurement.getSupplierId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found")
        );
        ProcurementEntity procurementEntity = ProcurementEntity.builder()
                .requiredDate(createProcurement.getRequiredDate())
                .totalAmount(createProcurement.getTotalAmount())
                .currency(createProcurement.getCurrency())
                .description(createProcurement.getDescription())
                .paymentMethod(createProcurement.getPaymentMethod())
                .paymentStatus(createProcurement.getPaymentStatus())
                .procurement_number(createProcurement.getProcurementNumber())
                .procurementType(createProcurement.getProcurementType())
                .status("Menunggu Pembayaran")
                .title(createProcurement.getTitle())
                .supplierEntity(supplierEntity)
                .build();
        procurementRepository.save(procurementEntity);

        for (CreateUpdateProcurementItemDto item : createProcurement.getCreateUpdateProcurementItemDto()) {
            ItemEntity itemFound =  itemRepository.findById(item.getItemId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
            ProcurementItemEntity procurementItemEntity = ProcurementItemEntity.builder()
                    .price(item.getPrice())
                    .qty(item.getQty())
                    .itemEntity(itemFound)
                    .procurementEntity(procurementEntity)
                    .build();
            procurementItemRepository.save(procurementItemEntity);
        }

        return procurementEntity;
    }
}
