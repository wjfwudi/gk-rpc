package com.smgeek.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个类的公共方法
     *
     * @param clazz 目标类
     * @return 当前类声明的公共方法
     */
    @SuppressWarnings("rawtypes")
    public static Method[] getPublicMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> publicMethods = new ArrayList<>();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                publicMethods.add(method);
            }
        }
        return publicMethods.toArray(new Method[0]);
    }

    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
