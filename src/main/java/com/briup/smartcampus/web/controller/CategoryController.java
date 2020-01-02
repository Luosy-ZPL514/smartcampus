package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Category;
import com.briup.smartcampus.exception.ServiceException;
import com.briup.smartcampus.service.ICategoryService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有栏目")

    public Message findAll() throws ServiceException {
        List<Category> categories = categoryService.selectAll();
        return MessageUtil.success(categories);
    }

    @GetMapping("/findById")
    @ApiOperation(value = "根据id查询指定的栏目")
    @ApiImplicitParam(name = "id", value = "栏目id", paramType = "query", dataType = "int", required = true)
    public Message findById(int id) throws ServiceException {
        Category category = categoryService.selectById(id);
        return MessageUtil.success(category);
    }

    @PostMapping("/addCategory")
    @ApiOperation(value = "添加栏目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键(不需要填写)", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "code", value = "栏目编号", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "栏目姓名", paramType = "query", dataType = "String")
    })
    public Message addCategory(Category category) throws ServiceException {
        categoryService.insertOrUpdate(category);
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改栏目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "code", value = "栏目编号", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "栏目姓名", paramType = "query", dataType = "String")
    })
    public Message update(Category category) throws ServiceException {
        categoryService.insertOrUpdate(category);
        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除指定的栏目")
    @ApiImplicitParam(name = "id", value = "栏目id", paramType = "query", dataType = "int", required = true)
    public Message deleteById(int id) throws ServiceException {
        categoryService.deleteById(id);
        return MessageUtil.success();
    }
}
