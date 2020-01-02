package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Category;
import com.briup.smartcampus.exception.ServiceException;

import java.util.List;

public interface ICategoryService {
    List<Category> selectAll() throws ServiceException;
    Category selectById(int id) throws ServiceException;
    void insertOrUpdate(Category category) throws ServiceException;
    void deleteById(int id) throws ServiceException;
}
