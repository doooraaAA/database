package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.entity.Table;

import java.util.List;

/**
 * (Types)表服务接口
 *
 * @author makejava
 * @since 2021-02-04 12:49:15
 */
public interface TableService {

    int getTableStatus(String TableNo);
    void updateTableStatus(String TableNo,Integer status);
    boolean selecttablebyNo(String TableNo);
    List<Table> queryAll();
    void insert(String TableNo);
    void delete(String TableNo);

}