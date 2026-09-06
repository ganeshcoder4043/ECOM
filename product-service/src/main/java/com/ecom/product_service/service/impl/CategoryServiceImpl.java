package com.ecom.product_service.service.impl;

import com.ecom.product_service.dto.CategoryRequestDto;
import com.ecom.product_service.dto.CategoryResponseDto;
import com.ecom.product_service.dto.ExtendedCategoryResponseDto;
import com.ecom.product_service.entity.Category;
import com.ecom.product_service.entity.Product;
import com.ecom.product_service.mapper.CategoryMapping;
import com.ecom.product_service.mapper.ProductMapping;
import com.ecom.product_service.repository.CategoryRepository;
import com.ecom.product_service.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapping.toCategoryResponseDto(savedCategory);
    }

    @Override
    public ExtendedCategoryResponseDto getCategoryById(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + categoryId));
        return convertToExtendedCategoryResponseDto(category);
    }

    @Override
    public List<ExtendedCategoryResponseDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<ExtendedCategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : categoryList){
            ExtendedCategoryResponseDto categoryResponseDto = convertToExtendedCategoryResponseDto(category);
            categoryResponseDtos.add(categoryResponseDto);
        }

        return categoryResponseDtos;

       /*return categoryRepository.findAll().stream()
               .map(CategoryMapping::toCategoryResponseDto)
               .toList();*/

    }

    @Override
    public CategoryResponseDto updateCategory(String CategoryId, CategoryRequestDto categoryRequestDto) {
        return null;
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + categoryId));
        categoryRepository.deleteById(categoryId);
        log.info("Category deleted successfully with ID: {}", categoryId);
    }


    private ExtendedCategoryResponseDto convertToExtendedCategoryResponseDto(Category category){
        List<Product> productList = category.getProducts();
        return new ExtendedCategoryResponseDto(category.getCategoryId(), category.getName(), category.getDescription(),
                productList.stream().map(ProductMapping::toProductResponseDto).toList());
    }
}
