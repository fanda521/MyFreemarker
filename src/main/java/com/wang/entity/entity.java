package com.wang.entity;

import java.sql.Timestamp;

public class entity {
    private String name;
    private int age;
    private double weight;
    private Timestamp birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public entity(String name, int age, double weight, Timestamp birth) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "entity{" +
                "name='" + name +
                ", age=" + age +
                ", weight=" + weight +
                ", birth=" + birth +
                '}';
    }
}
