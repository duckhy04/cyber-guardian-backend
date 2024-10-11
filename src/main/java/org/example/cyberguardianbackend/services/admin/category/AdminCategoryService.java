package org.example.cyberguardianbackend.services.admin.category;

import org.example.cyberguardianbackend.dto.CategoryDto;
import org.example.cyberguardianbackend.entity.Category;

import java.util.List;

public interface AdminCategoryService {
    Category saveCategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
