package org.example.cyberguardianbackend.services.admin.category;

import org.example.cyberguardianbackend.dto.CategoryDto;
import org.example.cyberguardianbackend.entity.Category;
import org.example.cyberguardianbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public AdminCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
