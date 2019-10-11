    package com.wang.servlet;

    import com.wang.dao.BoyDao;
    import com.wang.entity.Boy;
    import com.wang.tools.MyServlet;

    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;
    import javax.servlet.annotation.WebServlet;
    import java.sql.SQLException;

    @WebServlet(name = "BoyServlet",urlPatterns = "/BoyServlet")
    public class BoyServlet extends MyServlet {
        private  java.lang.Integer id;
        private  java.lang.String name;
        private  java.lang.Integer age;
        private  java.lang.String sex;
        private  java.lang.String hobby;
        private  java.util.Date birth;
        private  java.lang.Double weight;
        private  java.lang.String familyAddress;
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
            Boy boy=null;
            if(id==0){
                boy=new Boy(null,name,age,sex,hobby,birth,weight,familyAddress );
            }
            else {
                boy=new Boy( id,name,age,sex,hobby,birth,weight,familyAddress);
            }

            BoyDao boyDao=new BoyDao("test1","boy");
            try {
            boyDao.save(boy);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
