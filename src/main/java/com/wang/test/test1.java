package com.wang.test;

import com.wang.autocode.AutoCodeEntity;
import com.wang.autocode.AutoCodeDao;
import com.wang.dao.BoyDao;
import com.wang.dao.PersonDao;
import com.wang.entity.Boy;
import com.wang.entity.Person;

import java.sql.SQLException;
import java.util.Date;

public class test1 {
    public static void main(String[] args) {
//        testEntity();
//        testDao();
//        testEntity2();
//        testAutoCodeDao2();
        testDao2();

    }

    private static void testEntity() {
        AutoCodeEntity au=new AutoCodeEntity("test1","boy");
        try {
            au.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testEntity2() {
        AutoCodeEntity au=new AutoCodeEntity("test1","person");
        try {
            au.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testDao(){
        BoyDao db=new BoyDao("test1","boy");
        Boy boy=new Boy(null,"小豆子",3,"女","抓娃娃",new Date(),42.9,"吃豆子");
        try {
            db.save(boy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testDao2(){
        PersonDao pd=new PersonDao("test1","person");
        Person p=new Person(null,"阿衰",5,"男","烧脑",new Date(),34.9);
        try {
            pd.save(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testAutoCodeDao2(){
        AutoCodeDao acd=new AutoCodeDao("test1","person");

    }

}
