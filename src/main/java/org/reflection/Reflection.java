package org.reflection;

import java.lang.reflect.Method;

public class Reflection {

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes){
        Method method = null;
        try {
            method = clazz.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superclass = clazz.getSuperclass();
            if(!superclass.equals(Object.class)){
                return Reflection.getMethod(superclass,methodName,parameterTypes);
            }
        }
        return method;
    }

}
