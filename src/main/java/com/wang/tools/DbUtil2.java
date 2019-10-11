package com.wang.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil2 {
    static String url = "jdbc:mysql://127.0.0.1/comkp?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String user = "root";
    static String pwd = "331224";
    static String driver = "com.mysql.jdbc.Driver";


    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
