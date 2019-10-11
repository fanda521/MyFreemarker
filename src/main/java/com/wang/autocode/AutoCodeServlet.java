package com.wang.autocode;

import com.wang.dao.BoyDao;
import com.wang.entity.Boy;
import com.wang.tools.MyServlet;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import java.sql.SQLException;
import java.util.Date;


@WebServlet(name = "AutoCodeServlet",urlPatterns = "/AutoCodeServlet")
public class AutoCodeServlet extends MyServlet {
    private  String id;
    private  String name;
    private  int age;
    private  String sex;
    private  String[]hobby;
    private Date birth;
    private double weight;
    private String familyAddress;

    @Override
    public void executeService(ServletRequest req, ServletResponse res) {
        System.out.println("id="+id);
        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("sex="+sex);
        System.out.println("hobby="+hobby);
        System.out.println("birth="+birth);
        System.out.println("weight="+weight);
        System.out.println("familyAddress="+familyAddress);
        int ID=-1;
        Boy boy=null;
        if(id!=""&&!"".equals(id)){
             ID= Integer.parseInt(id);
            boy=new Boy(ID,name,age,sex,hobby[0],birth,weight,familyAddress);
        }
        else {
            boy=new Boy(null,name,age,sex,hobby[0],birth,weight,familyAddress);
        }

        BoyDao boyDao=new BoyDao("test1","boy");
        try {
            boyDao.save(boy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
