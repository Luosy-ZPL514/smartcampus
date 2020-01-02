package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Category;
import com.briup.smartcampus.bean.CategoryExample;
import com.briup.smartcampus.exception.ServiceException;
import com.briup.smartcampus.mapper.CategoryMapper;
import com.briup.smartcampus.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAll() throws ServiceException {
        CategoryExample categoryExample = new CategoryExample();
        List<Category> list = categoryMapper.selectByExample(categoryExample);
        return list;
    }

    @Override
    public Category selectById(int id) throws ServiceException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        return category;
    }

    @Override
    public void insertOrUpdate(Category category) throws ServiceException {
        if (category == null) {
            throw new ServiceException("参数为空");
        }

        if (category.getId() == null) {
            categoryMapper.insert(category);
        }else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
