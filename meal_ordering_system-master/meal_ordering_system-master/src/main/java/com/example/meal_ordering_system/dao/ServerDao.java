package com.example.meal_ordering_system.dao;

import com.example.meal_ordering_system.entity.Admin;
import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.Server;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Server)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-04 12:44:06
 */
public interface ServerDao {

    Server queryBySerNo(int SerNo);

    /**
     * 通过ID查询单条数据
     *
     * @param SerName 用户名
     * @return 实例对象
     */
    Server queryBySerName(String SerName);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Server> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param server 实例对象
     * @return 对象列表
     */
    List<Server> queryAll(Server server);

    /**
     * 新增数据
     *
     * @param server 实例对象
     * @return 影响行数
     */
    int insert(Server server);


    /**
     * 修改数据
     *
     * @param server 实例对象
     * @return 影响行数
     */
    int update(Server server);

    /**
     * 通过主键删除数据
     *
     * @param SerNo 主键
     * @return 影响行数
     */
    int deleteById(Integer SerNo);

}
