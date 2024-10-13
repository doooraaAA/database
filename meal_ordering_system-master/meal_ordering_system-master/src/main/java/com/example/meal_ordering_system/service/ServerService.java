package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Admin;
import com.example.meal_ordering_system.entity.Server;
import com.example.meal_ordering_system.entity.Types;

import java.util.List;

/**
 * (Server)表服务接口
 *
 * @author makejava
 * @since 2021-02-04 12:49:13
 */
public interface ServerService {

    /**
     * 通过ID查询单条数据
     *
     * @param SerName 主键
     * @return 实例对象
     */
    Server queryBySerName(String SerName) ;

    boolean login(String SerName,String SerPwd);

    Server queryBySerNo(Integer SerNo) ;
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Server> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param server 实例对象
     * @return 实例对象
     */
    Server insert(Server server);

    int update(Server server);


    /**
     * 通过主键删除数据
     *
     * @param SerNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer SerNo);

}