package org.classloader;

import java.lang.String;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    static {
        System.out.println("======static=======");
    }
    static String name = "Test";

    public Test(){
        System.out.println("======construct=====");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //会执行static区域的
        Class<Test> clazz = (Class<Test>) Class.forName("org.classloader.Test");
        System.out.println(clazz.getClassLoader().getName());
        Constructor<Test> constructor1 = clazz.getConstructor();
        Test test = constructor1.newInstance();
        System.out.println(Test.name);

        //不会执行
        Class<Test> aClass = (Class<Test>) Test.class.getClassLoader().loadClass("org.classloader.Test");
        System.out.println(aClass.getClassLoader().getName());
        Constructor<Test> constructor = aClass.getConstructor();
        Test t= constructor.newInstance();
        System.out.println(t);
    }
}
