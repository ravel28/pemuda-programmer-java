package com.pemudaprogrammer.items.itemlist.services;

import com.pemudaprogrammer.items.entities.CategoriesEntity;
import com.pemudaprogrammer.items.itemlist.dtos.CreateUpdateCategoryDto;
import com.pemudaprogrammer.items.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {
    final private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public CategoriesEntity createCategory(CreateUpdateCategoryDto createUpdateCategoryDto){
        CategoriesEntity save_data =  new CategoriesEntity();
        save_data.setCategory_name(createUpdateCategoryDto.getName());
        return categoryRepository.save(save_data);
    }
}
