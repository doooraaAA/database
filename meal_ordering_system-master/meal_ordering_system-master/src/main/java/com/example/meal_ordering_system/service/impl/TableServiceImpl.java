package com.example.meal_ordering_system.service.impl;
import com.example.meal_ordering_system.entity.Table;
import com.example.meal_ordering_system.dao.TableDao;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.meal_ordering_system.dao.TableDao;

import java.util.List;

/**
 * (Table)表服务实现类
 *
 * @author makejava
 * @since 2021-02-04 12:49:15
 */
@Service("TableService")
@Scope("prototype")
public class TableServiceImpl implements TableService {
    @Autowired
    @Qualifier("TableDao")
    private TableDao TableDao;
    public int getTableStatus(String TableNo){

        return this.TableDao.queryStatusById(TableNo);
    }
    public void updateTableStatus(String TableNo,Integer status){
        System.out.println(status);
       this.TableDao.updateStatusById(TableNo,status);
    }
    public boolean selecttablebyNo(String TableNo){
        Table table=this.TableDao.selecttable(TableNo);
        if(table==null){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public List<Table> queryAll() {
        return this.TableDao.queryAll();
    }
    public void insert(String TableNo){this.TableDao.insert(TableNo);}
    public void delete(String TableNo){this.TableDao.delete(TableNo);}

}