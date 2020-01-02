package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Link;
import com.briup.smartcampus.exception.ServiceException;
import com.briup.smartcampus.service.ILinkService;
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
@RequestMapping("/link")
@Api(description = "链接管理")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有链接")
    public Message selectAll() throws ServiceException {
        List<Link> links = linkService.findAll();
        return MessageUtil.success(links);
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除指定的链接")
    @ApiImplicitParam(name = "id", value = "链接id", paramType = "query", dataType = "int", required = true)
    public Message deleteById(int id) throws ServiceException {
        linkService.deleteById(id);
        return MessageUtil.success();
    }

    @PostMapping("/addLink")
    @ApiOperation(value = "添加链接")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键(不需要填写)", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "链接姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "url", value = "链接地址", paramType = "query", dataType = "String")
    })
    public Message addLink(Link link) throws ServiceException {
        linkService.insertOrUpdate(link);
        return MessageUtil.success();
    }

    @GetMapping("/findById")
    @ApiOperation(value = "根据id查询指定的链接")
    @ApiImplicitParam(name = "id", value = "链接id", paramType = "query", dataType = "int", required = true)
    public Message findById(int id) throws ServiceException {
        Link link = linkService.selectById(id);
        return MessageUtil.success(link);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改链接")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "name", value = "链接姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "url", value = "链接地址", paramType = "query", dataType = "String")
    })
    public Message update(Link link) throws ServiceException {
        linkService.insertOrUpdate(link);
        return MessageUtil.success();
    }

}
