    package com.wang.servlet;

    import com.wang.dao.CourseDao;
    import com.wang.entity.Course;
    import com.wang.tools.MyServlet;

    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;
    import javax.servlet.annotation.WebServlet;
    import java.sql.SQLException;

    @WebServlet(name = "CourseServlet",urlPatterns = "/CourseServlet")
    public class CourseServlet extends MyServlet {
        private  java.lang.Integer courseId;
        private  java.lang.String courseName;
    @Override
        public void executeService(ServletRequest req, ServletResponse res) {
        System.out.println("courseId="+courseId);
        System.out.println("courseName="+courseName);
            Course course=null;
            if(courseId==0){
                course=new Course(null,courseName );
            }
            else {
                course=new Course( courseId,courseName);
            }

            CourseDao courseDao=new CourseDao("test1","course");
            try {
            courseDao.save(course);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
