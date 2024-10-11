package org.example.cyberguardianbackend.controller.admin;

import org.example.cyberguardianbackend.dto.CategoryDto;
import org.example.cyberguardianbackend.entity.Category;
import org.example.cyberguardianbackend.services.admin.category.AdminCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;

    public AdminCategoryController(AdminCategoryService adminCategoryService) {
        this.adminCategoryService = adminCategoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = adminCategoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = adminCategoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
