package com.alice.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by User on 010 10.05.17.
 */
abstract class AbstractDAO<K extends Serializable, T> {

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    AbstractDAO() {

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();

        Type type = genericSuperclass.getActualTypeArguments()[1];

        if (type instanceof Class) {
            this.persistentClass = (Class<T>) type;
        } else if (type instanceof ParameterizedType) {
            this.persistentClass = (Class<T>) ((ParameterizedType) type).getRawType();
        }
    }

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    T getByKey(K key) {
        return getSession().get(persistentClass, key);
    }

    @SuppressWarnings("unchecked")
    T getByName(String query, String name){
        return (T) getSession().createQuery(query).setParameter(0, name).uniqueResult();
    }

    void delete(String query, String entity) {
        T t = getByName(query,entity);
        if (t != null) {
            getSession().delete(t);
        } else {
            System.out.println("There is no object in DB with name " + entity);
        }
    }

    void persist(T entity) {
        getSession().saveOrUpdate(entity);
    }

}
