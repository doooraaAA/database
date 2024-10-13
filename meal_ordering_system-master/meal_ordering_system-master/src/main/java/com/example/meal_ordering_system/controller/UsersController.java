package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Server;
import com.example.meal_ordering_system.entity.Users;
import com.example.meal_ordering_system.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.meal_ordering_system.entity.Users;
import com.example.meal_ordering_system.entity.Table;
import com.example.meal_ordering_system.service.UsersService;
import com.example.meal_ordering_system.service.TableService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2021-02-04 12:51:21
 */
@Controller("usersController")
@RequestMapping("users")
@Scope("prototype")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    @Qualifier("usersService")
    private UsersService usersService;
    @Autowired
    @Qualifier("TableService")
    private TableService tableService;
    @RequestMapping("delete")
    public String delete(Integer id) {
        System.out.println("controller:  "+id);
        usersService.deleteById(id);
        return "redirect:/users/allUsers";
    }

    @RequestMapping("/allusers")
    public String  allusers(Model model ){

        List<Users> Userlist = usersService.queryAll();
        for (Users users : Userlist) {
            System.out.println("UserNo: " + users.getId());
            System.out.println("UserName: " + users.getName());
            // 打印其他属性
        }
        System.out.println(123);
        model.addAttribute("Userlist",Userlist);

        return "/admin/user";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping ("queryById")
    public Users queryById(Integer id) {
        return this.usersService.queryById(id);
    }


    @RequestMapping ("checksessionorder")
    public String checksessionorder(HttpSession session) {

        if (session.getAttribute("user_session")==null){
            return "redirect:/public/qiantai/notlogin.jsp";
        }
        else{
            return"redirect: /public/qiantai/order.jsp";
        }
    }
    @RequestMapping ("checksessioncenter")
    public String checksessioncenter(HttpSession session) {
        if (session.getAttribute("user_session")==null){
            return "redirect:/public/qiantai/notlogin.jsp";
        }
        else{
            return"redirect: /public/qiantai/center.jsp";
        }
    }


    /**
     * 登录方法
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(Users user, HttpServletRequest request,HttpSession session){
        boolean loginType=usersService.login(user.getName(), user.getPwd(),user.getPhone());
        boolean isreg = usersService.selectbyphone(user.getPhone());
        if (isreg==false){
            if(loginType){
                session.setAttribute("user_session",usersService.selectbyphoneNo(user.getPhone()));
                //return "redirect:/menus/qiantai/allMenus";
                Users user1=usersService.selectbyphoneNo(user.getPhone());
                System.out.println(user.getId());
                System.out.println(user.getTableNo());
                System.out.println("111");
                if(usersService.selectusertable(user1.getId())==null||usersService.selectusertable(user1.getId())==""){
                    return "redirect:/public/qiantai/selecttable.jsp";
                }
                else{
                    return "redirect: /menus/qiantai/allMenus";
                }

            }else{
                session.setAttribute("message","用户名密码错误");
                return "qiantai/userLoginFail";
            }
        }
       else{
            session.setAttribute("message","您还没有注册！");
           return "qiantai/notreg";
        }
    }
    //登出,地址/users/logout
    @RequestMapping("logout")
    public String logout(HttpSession session){
        Users user = (Users)session.getAttribute("user_session");
        String TableNo=usersService.selectusertable(user.getId());
        System.out.println(user.getId());
        System.out.println(TableNo);
        tableService.updateTableStatus(TableNo,0);
        int userid=usersService.selectbytable(TableNo);
        usersService.updateUserTable(userid,null);
        //清除session
        session.removeAttribute("user_session");

        //重定向到登录页面的跳转方法
        return "redirect:/public/qiantai/login.jsp";
    }

    @RequestMapping("insert")
    public String insert(@Param("name") String name,@Param("pwd") String pwd,@Param("realname") String realname,@Param("sex") String sex,@Param("age") Integer age,@Param("card") String card,@Param("address") String address,@Param("Phone") String phone,@Param("email")String email,@Param("code")String code,@Param("type")Integer type){
        Users user=new Users(name,pwd,realname,sex,age,card,address,phone,email,code,type);
        boolean insertType=usersService.selectbyphone(user.getPhone());
        Integer insertType2 =usersService.queryByname(name);
        if(insertType2==null){
            if (insertType){
                usersService.insert(user);
                return "redirect:../public/qiantai/login.jsp";
            }
            else{
                return"redirect:../public/qiantai/rereg.jsp";
            }
        }
        else{
            return"redirect:../public/qiantai/rename.jsp";
        }


    }
    @RequestMapping("removesession")
    public String removesession(HttpSession session){
        session.removeAttribute("user_session");
        return "redirect:/users/relogin";
    }
    @RequestMapping("update")
    public String update(HttpSession session,@Param("id")Integer id,@Param("name") String name,@Param("pwd") String pwd,@Param("realname") String realname,@Param("sex") String sex,@Param("age") Integer age,@Param("card") String card,@Param("address") String address,@Param("Phone") String phone,@Param("email")String email,@Param("code")String code,@Param("type")Integer type){
        Users user=new Users(id,name,pwd,realname,sex,age,card,address,phone,email,code,type);
        if(user.getId()==null&&session==null){
            return "redirect:/users/relogin";
        }
        usersService.update(user);

        //session.removeAttribute("user_session");
        return "redirect:/users/relogin";
    }
    @RequestMapping("relogin")
    public String relogin(Users user, HttpServletRequest request,HttpSession session){
        boolean loginType=usersService.login(user.getName(), user.getPwd(),user.getPhone());
        if(loginType){
            session.setAttribute("user_session",usersService.queryById(usersService.queryByname(user.getName())));
            return "redirect:/menus/qiantai/allMenus";
        }else{
            session.setAttribute("message","请重新登陆");
            return "qiantai/relogin";
        }
    }
    @RequestMapping("selectTable")
    public String selectTable(HttpSession session, @RequestParam("id") Integer userId , @RequestParam("TableNo") String tableNo) {
        Users user=new Users(userId,tableNo);
        //System.out.println(user.getId());
        //System.out.println(user.getTableNo());
        //检查餐桌是否存在于表中
        boolean tableType=tableService.selecttablebyNo(user.getTableNo());
        if(tableType==true){
            int status = tableService.getTableStatus(user.getTableNo());
            System.out.println(status);
            //如果桌号状态为1，返回选择错误信息
            if (status == 1) {
                session.setAttribute("message","餐桌已有人！如确认桌号输入无误，请联系服务员处理");
                return "redirect:../public/qiantai/tablefault.jsp";
            }

            //如果餐桌无人，更新用户桌号信息
            else{
                System.out.println(user.getTableNo());
                tableService.updateTableStatus(user.getTableNo(),1);
                usersService.updateUserTable(user.getId(), user.getTableNo());
                return "redirect:/menus/qiantai/allMenus";
            }
        }
        else{
            session.setAttribute("message","不存在此餐桌！请重新输入");
            return "redirect:../public/qiantai/tablefault.jsp";
        }

    }
}
