package com.example.meal_ordering_system.dao;
import com.example.meal_ordering_system.entity.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository("TableDao")
public interface TableDao {
    int queryStatusById(String TableNo);

    void updateStatusById(@Param("TableNo") String TableNo, @Param("Status") Integer Status);
    Table selecttable(String TableNo);
    List<Table> queryAll();
    void insert(String TableNo);
    void delete(String TableNo);
}
