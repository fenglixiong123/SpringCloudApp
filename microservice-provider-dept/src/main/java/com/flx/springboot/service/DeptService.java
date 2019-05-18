package com.flx.springboot.service;

import com.flx.springboot.entity.Dept;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 17:08
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();

}
