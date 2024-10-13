package com.example.meal_ordering_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





public class Server  {

    private int SerNo ;

    private String SerName;

    private String SerSex;

    private String SerAge;

    private String SerPwd;

    public Server() {
    }

    public Server(int SerNo, String SerName, String SerSex, String SerAge, String SerPwd) {
        this.SerNo = SerNo;
        this.SerName = SerName;
        this.SerSex = SerSex;
        this.SerAge = SerAge;
        this.SerPwd = SerPwd;
    }

    public int getSerNo() {
        return SerNo;
    }

    public void setSerNo(int SerNo) {
        this.SerNo = SerNo;
    }

    public String getSerName() {
        return SerName;
    }

    public void setSerName(String SerName) {
        this.SerName = SerName;
    }

    public String getSerSex() {
        return SerSex;
    }

    public void setSerSex(String SerSex) {
        this.SerSex = SerSex;
    }

    public String getSerAge() {
        return SerAge;
    }

    public void setSerAge(String SerAge) {
        this.SerAge = SerAge;
    }

    public String getSerPwd() {
        return SerPwd;
    }

    public void setSerPwd(String SerPwd) {
        this.SerPwd = SerPwd;
    }
}
