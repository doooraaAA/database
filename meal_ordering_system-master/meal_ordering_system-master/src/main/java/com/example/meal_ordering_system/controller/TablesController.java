package com.example.meal_ordering_system.controller;
import com.example.meal_ordering_system.entity.Table;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.TableService;
import com.example.meal_ordering_system.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Types)表控制层
 *
 * @author makejava
 * @since 2021-02-04 12:51:21
 */
@Controller
@RequestMapping("Tables")
public class TablesController {
    private final UsersController usersController;

    public TablesController(UsersController usersController) {
        this.usersController = usersController;}
    /**
     * 服务对象
     */
    @Autowired
    @Qualifier("TableService")
    private TableService tableService;

    @Autowired
    @Qualifier("usersService")
    private UsersService usersService;
    /**
     * 查询所有菜单类别
     * @param model
     * @return
     */
    @RequestMapping("queryAll")
    public String queryAll(Model model){

        List<Table> table=tableService.queryAll();
        model.addAttribute("table",table);
        for (Table t : table) {
            System.out.println("TableNo: " + t.getTableNo());
            System.out.println("Status: " + t.getTableStatus());
            // 如果Table类中还有其他属性，可以继续在这里添加打印代码
            System.out.println("-------");
        }
        return "server/Table";
    }
    @RequestMapping("queryAlladmin")
    public String queryAlladmin(Model model){

        List<Table> table=tableService.queryAll();
        model.addAttribute("table",table);
        return "admin/Table";
    }
    @RequestMapping("delete")
    public String delete(Model model,String id,HttpSession session){
        if(tableService.getTableStatus(id)==0){
            tableService.delete(id);
        }
        else{
            tableService.updateTableStatus(id,0);
            int userid=usersService.selectbytable(id);
            usersService.updateUserTable(userid,null);
            tableService.delete(id);
            usersController.removesession(session);

        }
        return "redirect:/Tables/queryAlladmin";
    }

//
//    /**
//     * 通过id删除菜单类别
//     * @param model
//     * @param id
//     * @return
//     */
//    @RequestMapping("delete")
//    public String delete(Model model,@Param("id") int id){
//        this.typesService.delete(id);
//        return queryAll(model);
//    }
//
//    /**
//     * 修改菜单类别
//     * @param model
//     * @param id
//     * @return
//     */


    /**
     * 根据id查询元素
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("updateStatus")
    public String updateStatus(Model model,@Param("id") String id,HttpSession session){
        System.out.println(id);
        int Status = tableService.getTableStatus(id);
        if(Status==1){

            tableService.updateTableStatus(id,0);
            int userid=usersService.selectbytable(id);
            usersService.updateUserTable(userid,null);
           usersController.removesession(session);
            return "redirect:/Tables/queryAll";
        }
        else {
            return "/server/TableStatusChangeFail";
            //tableService.updateTableStatus(id,1);
        }
        //model.addAttribute("type",type);
        //return "redirect:/Tables/queryAll";
    }
    @RequestMapping("updateStatusadmin")
    public String updateStatusadmin(Model model,@Param("id") String id,HttpSession session){
        System.out.println(id);
        int Status = tableService.getTableStatus(id);
        if(Status==1){

            tableService.updateTableStatus(id,0);
            int userid=usersService.selectbytable(id);
            usersService.updateUserTable(userid,null);
            usersController.removesession(session);
            return "redirect:/Tables/queryAlladmin";
        }
        else {
            return "/admin/TableStatusChangeFail";
            //tableService.updateTableStatus(id,1);
        }
        //model.addAttribute("type",type);
        //return "redirect:/Tables/queryAll";
    }

    /**
     * 插入元素
     * @param model
     * @param name
     * @return
     */
    @RequestMapping("insert")
    public String insert(Model model,String TableNo){
        boolean TableType=tableService.selecttablebyNo(TableNo);
        if(TableType==true){
            return "admin/tableinsertFail";
        }
        else {
            tableService.insert(TableNo);
            return "redirect:/Tables/queryAll";
        }
    }
}