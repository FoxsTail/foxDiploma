package com.alice.dao;

import com.alice.domain.Category;

import java.util.List;

/**
 * Created by User on 013 13.05.17.
 */
public interface CategoryDAO {
    Category findById(Integer id);
    Category findByCategoryName(String categoryName);
    void addCategory(Category category);
    void removeCategory(String categoryName);
    List<Category> listCategory();
}
