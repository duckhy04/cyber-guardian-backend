package org.example.cyberguardianbackend.services.user.category;

import org.example.cyberguardianbackend.entity.Category;
import org.example.cyberguardianbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public UserCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
