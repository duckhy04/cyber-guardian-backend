package org.example.cyberguardianbackend.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.cyberguardianbackend.entity.Category;
import org.example.cyberguardianbackend.services.user.category.UserCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserCategoryController {

    private final UserCategoryService userCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = userCategoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

}
