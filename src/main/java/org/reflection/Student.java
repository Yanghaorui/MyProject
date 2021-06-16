package org.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Student {

    private String no;
    private String name;
    @Ignore
    private String address;

    private String klasse;

    private int age;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toCsv(){
        Field[] fields = this.getClass().getDeclaredFields();
        return Arrays.stream(fields).filter(field->{
            Ignore annotation = field.getAnnotation(Ignore.class);
            return null == annotation;
        }).map(field -> {
            field.setAccessible(true);
            try {
                Object o = field.get(this);
                if(null != o){
                    return String.valueOf(o);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        }).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAddress("address");
        student.setAge(25);
        student.setName("name");
//        student.setNo("1");
        student.setKlasse("class.1");
        System.out.println(student.toCsv());
    }
}
