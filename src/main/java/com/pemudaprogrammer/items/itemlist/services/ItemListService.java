package com.pemudaprogrammer.items.itemlist.services;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.brand.entities.BrandsEntity;
import com.pemudaprogrammer.items.entities.CategoriesEntity;
import com.pemudaprogrammer.items.entities.ItemEntity;
import com.pemudaprogrammer.items.entities.ViewItemEntity;
import com.pemudaprogrammer.items.itemlist.dtos.CreateUpdateItemDto;
import com.pemudaprogrammer.brand.repositories.BrandRepository;
import com.pemudaprogrammer.items.repositories.CategoryRepository;
import com.pemudaprogrammer.items.repositories.ItemRepository;
import com.pemudaprogrammer.items.repositories.ViewItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemListService {
   private final ItemRepository itemRepository;
   private final BrandRepository brandRepository;
   private final CategoryRepository categoryRepository;
   private final ViewItemRepository viewItemRepository;

    @Autowired
    public ItemListService(
            ItemRepository itemRepository,
            BrandRepository brandRepository,
            CategoryRepository categoryRepository,
            ViewItemRepository viewItemRepository
    ){
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.viewItemRepository = viewItemRepository;
    }

    public ItemEntity createItem (CreateUpdateItemDto createItemDto){
        ItemEntity createItem = new ItemEntity();
        createItem.setItem_name(createItemDto.getItem_name());

        // Fetch brand entity by id
        BrandsEntity brand = brandRepository.findById(createItemDto.getBrand_id())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        // Fetch category entity by id
        CategoriesEntity category = categoryRepository.findById(createItemDto.getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        createItem.setBrandEntity(brand);
        createItem.setCategoryEntity(category);
        return itemRepository.save(createItem);
    }

    public List<ViewItemEntity> getListItems(FilterPaginationDto filterPaginationDto) {
        Pageable pageable = PageRequest.of(filterPaginationDto.getCurrent_page(), filterPaginationDto.getTake());
        Page<ViewItemEntity> pageResult = viewItemRepository.findAll(pageable);
        return pageResult.getContent();
    }

    public ItemEntity updateItems(CreateUpdateItemDto createUpdateItemDto) {
        ItemEntity find_data = itemRepository.findById(createUpdateItemDto.getId()).orElseThrow(() -> new RuntimeException("Item not found"));
        find_data.setItem_name(createUpdateItemDto.getItem_name());

        // Fetch brand entity by id
        BrandsEntity brand = brandRepository.findById(createUpdateItemDto.getBrand_id())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        // Fetch category entity by id
        CategoriesEntity category = categoryRepository.findById(createUpdateItemDto.getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        find_data.setBrandEntity(brand);
        find_data.setCategoryEntity(category);
        return itemRepository.save(find_data);
    }

    //TODO :: Buatkan function delete jika sudah ada pengadaan
}
