package com.pemudaprogrammer.product_list.categories.categorylist.services;

import com.pemudaprogrammer.product_list.categories.entities.CategoriesEntity;
import com.pemudaprogrammer.product_list.categories.categorylist.dtos.CreateUpdateCategoryDto;
import com.pemudaprogrammer.product_list.categories.entities.ViewCategoriesEntity;
import com.pemudaprogrammer.product_list.categories.repositories.CategoryRepository;
import com.pemudaprogrammer.product_list.categories.repositories.ViewCategoriesRepository;
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
public class CategoryService {
    final private CategoryRepository categoryRepository;
    final private ViewCategoriesRepository viewCategoriesRepository;

    @Autowired
    public CategoryService (
            CategoryRepository categoryRepository,
            ViewCategoriesRepository viewCategoriesRepository
    ){
        this.categoryRepository = categoryRepository;
        this.viewCategoriesRepository = viewCategoriesRepository;
    }

    public CategoriesEntity createCategory(CreateUpdateCategoryDto createUpdateCategoryDto){
        CategoriesEntity save_data =  new CategoriesEntity();
        save_data.setCategory_name(createUpdateCategoryDto.getName());
        return categoryRepository.save(save_data);
    }

    public List<ViewCategoriesEntity> getList(FilterPaginationDto filterPaginationDto){
        Pageable pageable = PageRequest.of(filterPaginationDto.getCurrent_page(), filterPaginationDto.getTake());
        Page<ViewCategoriesEntity> pageResult = viewCategoriesRepository.findAll(pageable);
        return pageResult.getContent();
    }

    public CategoriesEntity updateCategory(Integer id, CreateUpdateCategoryDto updateCategoryDto){
        CategoriesEntity save_data = categoryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        save_data.setCategory_name(updateCategoryDto.getName());
        return categoryRepository.save(save_data);
    }
}
