package ru.specialist.DAO.base;

import ru.specialist.DAO.course.Course;

import java.util.List;

public interface BaseService<T extends BaseEnity> {

    List<T> findAll();
    T findById(int id);
    T save(T course);
    void delete(int id);

}
