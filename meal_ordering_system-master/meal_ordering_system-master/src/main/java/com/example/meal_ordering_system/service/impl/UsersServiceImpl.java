package com.example.meal_ordering_system.service.impl;

import com.example.meal_ordering_system.dao.UsersDao;
import com.example.meal_ordering_system.entity.Users;
import com.example.meal_ordering_system.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2021-02-04 12:49:15
 */
@Service("usersService")
@Scope("prototype")
public class UsersServiceImpl implements UsersService {
    @Autowired
    @Qualifier("usersDao")
    private UsersDao usersDao;

    /**
     * 登录查询
     * @param name
     * @return
     */
    public boolean login(@Param("name") String name, @Param("pwd") String pwd,@Param("phone") String phone){
    //public boolean login(String name, String pwd){
        Users user= usersDao.queryOne(pwd,phone);
        if(user==null){
            return false;}
        else{
            return true;}
    }

    public boolean selectbyphone(@Param("phone") String phone){
        Users user=usersDao.selectbyphone(phone);
        if(user==null){
            return true;}
        else{
            return false;}

    }
    public Users selectbyphoneNo(@Param("phone") String phone){
        Users user=usersDao.selectbyphone(phone);
        return user;

    }
    public boolean updateUserTable( @Param("userId")Integer userId, @Param("tableNo")String tableNo){
        this.usersDao.updatetable(userId,tableNo);
        return true;
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Override
    public Users queryById(Integer id) {
        return this.usersDao.queryById(id);
    }

    @Override
    public int selectbytable(String tableNo) {
        return this.usersDao.selectbytable(tableNo);
    }
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public List<Users> queryAll() {
        return this.usersDao.queryAll();
    }
    @Override
    public int insert(Users user) {
        return this.usersDao.insert(user);
    }
    @Override
    public String selectusertable(int userid){
        return this.usersDao.selectusertable(userid);
    };
    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.usersDao.deleteById(id) > 0;
    }

    @Override
    public  Integer queryByname(String name) {
        return this.usersDao.queryByname(name);
    }
}