package com.example.meal_ordering_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Table {
    private String TableNo;

    private Integer Status;


    public Table(String TableNo, Integer Status) {
        this.TableNo = TableNo;
        this.Status = Status;
    }
    public Table() {
    }
    public Integer getTableStatus(String TableNo) {
        return Status;
    }
    public Integer getTableStatus() {
        return Status;
    }
    public String getTableNo() {
        return TableNo;}
    public void setNo(String TableNo) {
        this.TableNo = TableNo;
    }
    public void setstatus(Integer Status) {
        this.Status = Status;
    }
    public Integer getName() {
        return Status;
    }
    public String getId() {
        return TableNo;}
}