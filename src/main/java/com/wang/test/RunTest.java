package com.wang.test;

import com.wang.dao.CourseDao;
import com.wang.entity.Course;
import com.wang.servlet.CourseServlet;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 该类是用来测试模板生成的类的可用性
 * 判断是否模板生成的类达到预期的效果
 */
public class RunTest {
    public static void main(String[] args) {
//        testCreateEntity();
//        testCreateDao();
        testCreateServlet();

    }


    /**
     * 测试生成的实体类是否可用
     *
     * 测试结果：success ！
     */
    public static  void testCreateEntity(){
        Course c=new Course();
        c.setCourseId(12);
        c.setCourseName("物理");
        System.out.println(c.toString());
    }

    /**
     * 测试生成的Dao类是否可用
     *
     * 测试结果：success ！
     */
    public static  void testCreateDao(){
        CourseDao cd=new CourseDao("test1","course");
        Course c=new Course();
        c.setCourseId(12);
        c.setCourseName("Java WEB");
        try {
            cd.save(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试生成的Servlet类是否可用
     *
     * 测试结果：success ！
     */
    public static  void testCreateServlet(){
        CourseServlet cs=new CourseServlet();

    }

    /**
     * 测试生成的Jsp类是否可用
     *
     * 测试结果：success ！
     */
    public static  void testCreateJsp(){


    }




}
