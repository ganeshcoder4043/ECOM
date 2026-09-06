package com.ecom.product_service.controller;

import com.ecom.product_service.dto.CategoryRequestDto;
import com.ecom.product_service.dto.CategoryResponseDto;
import com.ecom.product_service.dto.ExtendedCategoryResponseDto;
import com.ecom.product_service.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return categoryService.createCategory(categoryRequestDto);
    }

    @GetMapping("/all")
    public List<ExtendedCategoryResponseDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PutMapping("/{categoryId}")
    public CategoryResponseDto updateCategory(@PathVariable String categoryId, @RequestBody CategoryRequestDto categoryRequestDto){
        return categoryService.updateCategory(categoryId,categoryRequestDto);
    }

    @GetMapping("/{categoryId}")
    public CategoryResponseDto getCategoryById(@PathVariable String categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable String categoryId){
        categoryService.deleteCategory(categoryId);
        return "Category deleted successfully with ID: "+ categoryId;
    }
}
