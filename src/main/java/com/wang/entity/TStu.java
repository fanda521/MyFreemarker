package com.wang.entity;

    public class TStu {

     //学生ID
     private java.lang.Integer stuId;
     //雪上姓名
     private java.lang.String stuName;
     //学号
     private java.lang.String stuNo;
     //年龄
     private java.lang.Integer stuAge;
     //学生生日
     private java.util.Date stuBirth;

    public TStu(){

    }


    public  TStu(java.lang.Integer stuId, java.lang.String stuName, java.lang.String stuNo, java.lang.Integer stuAge, java.util.Date stuBirth )
    {
    this.stuId = stuId;
    this.stuName = stuName;
    this.stuNo = stuNo;
    this.stuAge = stuAge;
    this.stuBirth = stuBirth;
    }



    public java.lang.Integer getStuId() {
        return stuId;
    }
    public java.lang.String getStuName() {
        return stuName;
    }
    public java.lang.String getStuNo() {
        return stuNo;
    }
    public java.lang.Integer getStuAge() {
        return stuAge;
    }
    public java.util.Date getStuBirth() {
        return stuBirth;
    }


    @Override
    public String toString() {
    return "TStu{" +
        "stuId= " + stuId +
        "stuName= " + stuName +
        "stuNo= " + stuNo +
        "stuAge= " + stuAge +
        "stuBirth= " + stuBirth +
    "}";
    }
}
