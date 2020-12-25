package ru.specialist.DAO.base;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    List<T> findAll();
    T findById(int id);
    T save(T course);
    void delete(int id);

}
