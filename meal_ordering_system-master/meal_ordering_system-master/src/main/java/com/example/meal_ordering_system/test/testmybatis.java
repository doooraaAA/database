package com.example.meal_ordering_system.test;

import com.example.meal_ordering_system.dao.TypesDao;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.TypesService;
import com.example.meal_ordering_system.service.impl.TypesServiceImpl;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

public class testmybatis {


    public static void main(String[] args) {
        // 实例化 TypesService 接口的实现类
        TypesService typesService = new TypesServiceImpl();

        // 调用查询方法，获取菜品类型列表
        List<Types> typesList = typesService.queryAll();

        // 打印查询结果
        for (Types type : typesList) {
            System.out.println(type);
        }

    }
}
