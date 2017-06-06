package com.alice.service;

import com.alice.domain.Category;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
public interface CategoryService {
    Category findById(Integer id);

    Category findByCategoryName(String categoryName);

    void addCategory(Category category);

    void removeCategory(String categoryName);

    void updateUser(Category category);

    List<Category> listCategory();
}
