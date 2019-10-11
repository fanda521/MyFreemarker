package com.wang.entity;

    public class Person {

     //用户ID
     private java.lang.Integer tId;
     //姓名
     private java.lang.String tName;
     //年龄
     private java.lang.Integer tAge;
     //性别
     private java.lang.String tSex;
     //爱好
     private java.lang.String tHobby;
     //生日
     private java.util.Date tBirth;
     //体重
     private java.lang.Double tWeight;

    public Person(){

    }


    public  Person(java.lang.Integer tId, java.lang.String tName, java.lang.Integer tAge, java.lang.String tSex, java.lang.String tHobby, java.util.Date tBirth, java.lang.Double tWeight )
    {
    this.tId = tId;
    this.tName = tName;
    this.tAge = tAge;
    this.tSex = tSex;
    this.tHobby = tHobby;
    this.tBirth = tBirth;
    this.tWeight = tWeight;
    }



    public java.lang.Integer getTId() {
        return tId;
    }
    public java.lang.String getTName() {
        return tName;
    }
    public java.lang.Integer getTAge() {
        return tAge;
    }
    public java.lang.String getTSex() {
        return tSex;
    }
    public java.lang.String getTHobby() {
        return tHobby;
    }
    public java.util.Date getTBirth() {
        return tBirth;
    }
    public java.lang.Double getTWeight() {
        return tWeight;
    }


    @Override
    public String toString() {
    return "Person{" +
        "tId= " + tId +
        "tName= " + tName +
        "tAge= " + tAge +
        "tSex= " + tSex +
        "tHobby= " + tHobby +
        "tBirth= " + tBirth +
        "tWeight= " + tWeight +
    "}";
    }
}
