package com.jdemo.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2024/2/27 15:07
 */
public class CglibProxy {
    private Object target;

    public CglibProxy(Object target){
        this.target = target;
    }

    public static Object getProxy(Object target){
        Object proxy = Enhancer.create(target.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    // 提供增强代码
                    System.out.println("[cglib动态代理][日志] " + method.getName() + "，参数：" + Arrays.toString(objects));
                    //通过反射调用method对象所表示的方法,并获取该方法的返回值
                    //在具有指定参数的指定对象上调用此method对象表示的底层方法。
                    //此处就是通过target来确定调用的是具体哪个类中的方法
                    result = method.invoke(target, objects);
                    System.out.println("[cglib动态代理][日志] " + method.getName() + "，结 果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[cglib动态代理][日志] " + method.getName() + "，异常：" + e.getMessage());
                } finally {
                    System.out.println("[cglib动态代理][日志] " + method.getName() + "，方法执行完毕");
                }
                return result;
            }
        });
        return proxy;
    }
}
