package com.wang.entity;

    public class Boy {

     //用户ID
     private java.lang.Integer id;
     //姓名
     private java.lang.String name;
     //年龄
     private java.lang.Integer age;
     //性别
     private java.lang.String sex;
     //爱好
     private java.lang.String hobby;
     //生日
     private java.util.Date birth;
     //体重
     private java.lang.Double weight;
     //家庭住址
     private java.lang.String familyAddress;

    public Boy(){

    }


    public  Boy(java.lang.Integer id, java.lang.String name, java.lang.Integer age, java.lang.String sex, java.lang.String hobby, java.util.Date birth, java.lang.Double weight, java.lang.String familyAddress )
    {
    this.id = id;
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.hobby = hobby;
    this.birth = birth;
    this.weight = weight;
    this.familyAddress = familyAddress;
    }



    public java.lang.Integer getId() {
        return id;
    }
    public java.lang.String getName() {
        return name;
    }
    public java.lang.Integer getAge() {
        return age;
    }
    public java.lang.String getSex() {
        return sex;
    }
    public java.lang.String getHobby() {
        return hobby;
    }
    public java.util.Date getBirth() {
        return birth;
    }
    public java.lang.Double getWeight() {
        return weight;
    }
    public java.lang.String getFamilyAddress() {
        return familyAddress;
    }


    @Override
    public String toString() {
    return "Boy{" +
        "id= " + id +
        "name= " + name +
        "age= " + age +
        "sex= " + sex +
        "hobby= " + hobby +
        "birth= " + birth +
        "weight= " + weight +
        "familyAddress= " + familyAddress +
    "}";
    }
}
