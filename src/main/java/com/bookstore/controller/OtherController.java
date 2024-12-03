//package com.bookstore.controller;
//
//import com.bookstore.service.LoaiSachService;
//import com.bookstore.dto.CategoryDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class OtherController {
//    private final LoaiSachService categoryService;
//    private final CategoryModuleService categoryModuleService;
//
//    @GetMapping(value = Uri.CATEGORIES)
//    public ResponseEntity<?> RetrieveAllCategories(){
//        List<CategoryDto> categoryDtoList = categoryModuleService.convertToListCategoryDto(categoryService.retrieveAllParentCategory());
//        categoryDtoList.stream().forEach((category) -> {
//            category.setSubcategories(categoryModuleService.convertToListCategoryDto(categoryService.retrieveCategoriesByParentId(category.getId())));
//        });
//        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
//    }
//}
