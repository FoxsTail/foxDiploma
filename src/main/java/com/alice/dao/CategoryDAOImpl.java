package com.alice.dao;

import com.alice.domain.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
@Repository
@Transactional
public class CategoryDAOImpl extends AbstractDAO<Integer, Category> implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public Category findById(Integer id) {
        return getByKey(id);
    }

    public Category findByCategoryName(String categoryName) {
        return getByName("from Category where name=?", categoryName);
    }

    public void addCategory(Category category) {
        persist(category);
    }

    public void removeCategory(String categoryName) {
        delete("from Category where name=?",categoryName);
    }

    @SuppressWarnings("unchecked")
    public List<Category> listCategory() {
        return getSession().createQuery("from Category").list();
    }
}
