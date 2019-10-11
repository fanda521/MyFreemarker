package com.wang.entity;

    public class Course {

     //
     private java.lang.Integer courseId;
     //
     private java.lang.String courseName;

    public Course(){

    }


    public  Course(java.lang.Integer courseId, java.lang.String courseName )
    {
    this.courseId = courseId;
    this.courseName = courseName;
    }



    public java.lang.Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(java.lang.Integer courseId) {
        this.courseId = courseId;
    }

    public java.lang.String getCourseName() {
        return courseName;
    }

    public void setCourseName(java.lang.String courseName) {
        this.courseName = courseName;
    }



    @Override
    public String toString() {
    return "Course{" +
        "courseId= " + courseId +"  "+
        "courseName= " + courseName +"  "+
    "}";
    }
}
