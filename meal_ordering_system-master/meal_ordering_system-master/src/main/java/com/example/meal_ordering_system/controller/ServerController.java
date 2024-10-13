package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.Server;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.ServerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * (Server)表控制层
 *
 * @author makejava
 * @since 2021-02-04 12:51:19
 */
@Controller
@RequestMapping("server")
public class ServerController {
    /**
     * 服务对象
     */
    //自动注入业务层的ServerService类
    @Autowired
    @Qualifier("serverService")
    private ServerService serverService;

    //修改服务员信息
    @RequestMapping("update")
    public String update(Server server) {
        System.out.println("controller:  "+server.getSerNo());
        serverService.update(server);
        return "redirect:/server/allServers";
    }
    @RequestMapping("delete")
    public String delete(Integer SerNo) {
        System.out.println("controller:  "+SerNo);
        serverService.deleteById(SerNo);
        return "redirect:/server/allServers";
    }

    @RequestMapping("/toAddServer")
    public ModelAndView toAddServer(){
        ModelAndView modelAndView = new ModelAndView("/admin/servers_add");
        return modelAndView;
    }
    @RequestMapping("/insert")
    public String  insert(Server server, HttpSession session) throws IOException {

        serverService.insert(server);
        return "/admin/servers_add";
    }
    @RequestMapping("/allServers")
    public String  allServers(Model model ){

        List<Server> Serverlist = serverService.queryAllByLimit(0,100);
        for (Server server : Serverlist) {
            System.out.println("SerNo: " + server.getSerNo());
            System.out.println("SerName: " + server.getSerName());
            // 打印其他属性
        }
        System.out.println(123);
        model.addAttribute("Serverlist",Serverlist);

        return "/admin/server";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return  "/server/index";
    }

    @RequestMapping("/toUpdateServer")
    public String toUpdateServer(Integer SerNo, Model model){
        System.out.println(SerNo);
        Server server = serverService.queryBySerNo(SerNo);
        System.out.println(server.getSerNo());
        server.setSerNo(SerNo);
        System.out.println(server.getSerNo());
        model.addAttribute("server",server);

        return "/admin/servers_update";
    }

    //login业务的访问位置为/server/login
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Server server, HttpServletRequest request, HttpSession session){
        //调用login方法来验证是否是注册用户
        System.out.println(server.getSerName());
        System.out.println(server.getSerPwd());
        boolean loginType = serverService.login(server.getSerName(),server.getSerPwd());
        if(loginType){
            //如果验证通过,则将用户信息传到前台
            request.setAttribute("server",server);
            session.setAttribute("server_session",server);
            //并跳转到success.jsp页面
            return "/server/main";
        }else{
            //若不对,则返回
            request.setAttribute("message","用户名密码错误");
            return "/server/serverLoginFail";
        }
    }

    //登出,地址/admin/logout
    @RequestMapping("logout")
    public String logout(HttpSession session){
        //清除session
        session.removeAttribute("server_session");
        //重定向到登录页面的跳转方法
        return  "redirect:/server";
    }



}
