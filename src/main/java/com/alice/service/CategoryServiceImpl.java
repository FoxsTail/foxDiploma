package com.alice.service;

import com.alice.dao.CategoryDAO;
import com.alice.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;


    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }

    public Category findByCategoryName(String categoryName) {
        return categoryDAO.findByCategoryName(categoryName);
    }

    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    public void removeCategory(String categoryName) {
        categoryDAO.removeCategory(categoryName);
    }

    public void updateUser(Category category) {

    }

    public List<Category> listCategory() {
        return categoryDAO.listCategory();
    }
}
