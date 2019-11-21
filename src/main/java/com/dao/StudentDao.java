package com.dao;

import com.po.Emp;

import java.util.List;

/**
 * @author ${user}
 * @create 2019-11-21-11:00
 */
public interface StudentDao {

    /**
     *
     * 查询全部
     *
     * */
    List<Emp> selectAll();
}
