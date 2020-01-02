package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Link;
import com.briup.smartcampus.exception.ServiceException;

import java.util.List;

public interface ILinkService {
    List<Link> findAll() throws ServiceException;
    void deleteById(int id) throws ServiceException;
    void insertOrUpdate(Link link) throws ServiceException;
    Link selectById(int id) throws ServiceException;
}
