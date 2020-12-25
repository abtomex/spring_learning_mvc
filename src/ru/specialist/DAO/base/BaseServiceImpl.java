package ru.specialist.DAO.base;

import com.google.common.collect.Lists;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected abstract IRepository<T> getRepository();

    @Transactional(readOnly=true)
    public List<T> findAll() {
        return Lists.newArrayList(getRepository().findAll());
    }

    @Transactional(readOnly=true)
    public T findById(int id) {
        return getRepository().findOne(id);
    }


    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(int id) {
        getRepository().delete(id);
    }

}
