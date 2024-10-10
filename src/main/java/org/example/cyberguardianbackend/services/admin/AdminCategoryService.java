package org.example.cyberguardianbackend.services.admin;

import org.example.cyberguardianbackend.dto.CategoryDto;
import org.example.cyberguardianbackend.entity.Category;

import java.util.List;

public interface AdminCategoryService {
    Category createCategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
