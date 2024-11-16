package com.rrojase.retomitoccode.service.impl;

import com.rrojase.retomitoccode.exception.ModelNotFoundException;
import com.rrojase.retomitoccode.repository.IGenericRepository;
import com.rrojase.retomitoccode.service.ICRUDService;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDServiceImpl<T, ID> implements ICRUDService<T, ID> {

    protected abstract IGenericRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepository().findById(id).orElseThrow(()-> new ModelNotFoundException("Resource with ID " + id + " not found"));
    }

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        // Use Java Reflection
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName(); // get class name

        // build method
        String methodName = "setId" + className;
        Method method = clazz.getMethod(methodName);

        // invoke method (setId
        method.invoke(t, id);

        return getRepository().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
