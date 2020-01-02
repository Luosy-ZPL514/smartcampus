package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Link;
import com.briup.smartcampus.bean.LinkExample;
import com.briup.smartcampus.exception.ServiceException;
import com.briup.smartcampus.mapper.LinkMapper;
import com.briup.smartcampus.service.ILinkService;
import com.briup.smartcampus.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<Link> findAll() throws ServiceException {
        LinkExample linkExample = new LinkExample();
        List<Link> list = linkMapper.selectByExample(linkExample);
        return list;
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        linkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertOrUpdate(Link link) throws ServiceException {
        if(link == null) {
            throw new ServiceException("参数为空");
        }

        if(link.getId() == null) {
            linkMapper.insert(link);
        }else {
            linkMapper.updateByPrimaryKey(link);
        }
    }

    @Override
    public Link selectById(int id) throws ServiceException {
        Link link = linkMapper.selectByPrimaryKey(id);
        return link;
    }


}
