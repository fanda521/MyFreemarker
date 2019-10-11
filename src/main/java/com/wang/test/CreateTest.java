package com.wang.test;

import com.wang.autocode.AutoCodeDao;
import com.wang.create.CreateDao;
import com.wang.create.CreateEntity;
import com.wang.create.CreateJsp;
import com.wang.create.CreateServlet;

import java.sql.SQLException;

/**
 * 该类是用来测试模板的生成
 */
public class CreateTest {
    public static void main(String[] args) {
//        testAutoCodeEntity();
        testAutoCodeDao();
//        testAutoCodeServlet();
//        testAutoCodeJsp();


    }

    /**
     * 测试模板生成实体类
     *
     * 测试结果：success ！
     */
    public  static void testAutoCodeEntity(){
        CreateEntity ce=new CreateEntity("test1","course");
        try {
            ce.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试模板生成DAO类
     *
     * 测试结果：success ！
     */
    public  static void testAutoCodeDao(){
        CreateDao cd=new CreateDao("test1","boy");
        cd.template();
    }

    /**
     * 测试模板生成Servlet类
     *
     * 测试结果：success ！
     */
    public  static void testAutoCodeServlet(){
        CreateServlet cs=new CreateServlet("test1","course");
        try {
            cs.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试模板生成Jsp类
     *
     * 测试结果：success !
     */
    public  static  void testAutoCodeJsp(){
        CreateJsp cj=new CreateJsp("test1","boy");
        try {
            cj.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
