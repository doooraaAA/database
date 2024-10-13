package com.example.meal_ordering_system.service.impl;

import com.example.meal_ordering_system.dao.AdminDao;
import com.example.meal_ordering_system.dao.ServerDao;
import com.example.meal_ordering_system.entity.Admin;
import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.Server;
import com.example.meal_ordering_system.service.AdminService;
import com.example.meal_ordering_system.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2021-02-04 12:49:13
 */
@Service("serverService")
public class ServerServiceImpl implements ServerService {
    @Resource
    private ServerDao serverDao;

    /**
     * 通过ID查询单条数据
     *
     * @param SerName 用户名
     * @return 实例对象
     */
    @Override
    public Server queryBySerName(String SerName) {
        return this.serverDao.queryBySerName(SerName);
    }

    @Override
    public Server queryBySerNo(Integer SerNo) {
        System.out.println(SerNo);
        return this.serverDao.queryBySerNo(SerNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Server> queryAllByLimit(int offset, int limit) {
        System.out.println(345);
        return this.serverDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param server 实例对象
     * @return 实例对象
     */
    @Override
    public Server insert(Server server) {
        this.serverDao.insert(server);
        return server;
    }
    @Override
    public int update(Server server){
        System.out.println(server.getSerNo());
        this.serverDao.update(server);
        return 0;
    };

    //登录方法的实现,从jsp页面获取username与password
    public boolean login(String SerName, String SerPwd) {
        System.out.print(SerName);
        System.out.print(SerPwd);
        Server server = serverDao.queryBySerName(SerName);
        if (server != null) {
            if (server.getSerName().equals(SerName) && server.getSerPwd().equals(SerPwd))
                return true;
        }
        return false;
    }


    /**
     * 通过主键删除数据
     *
     * @param SerNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer SerNo) {
        return this.serverDao.deleteById(SerNo) > 0;
    }
}