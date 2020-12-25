package ru.specialist.DAO.base;

import org.springframework.data.repository.CrudRepository;

public interface IRepository<T extends BaseEntity> extends CrudRepository<T, Integer>{

}