package com.jdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2024/2/27 15:26
 */
public class JDKProxy {
    private Object target;
    public JDKProxy(Object target) {
        this.target = target;
    }
    // 通过该方法可以生成任意目标类所对应的代理类
    public Object getProxy(){
        /**
         * newProxyInstance()：创建一个代理实例
         * 其中有三个参数：
         * 1、classLoader：指定加载动态生成的代理类的类加载器（注：所有引入的第三方类库以及自己编写的java类 都是由 应用类加载器 负责加载的）
         【根类加载器（Bootstrap）> 扩展类加载器（Extension）> 系统类加载器（System）
         系统类加载器又称为应用类加载器】
         * 2、interfaces：获取目标对象实现的所有接口的class对象所组成的数组
         * 3、invocationHandler：设置代理对象实现目标对象的接口的方法的过程，即代理类中如何重写接口中的抽象方法
         */
        //第一个参数,获取代理对象的类加载器 （类加载器是程序中默认的类加载器，一般来说，Java应用的类都是由它来完成加载。所以，此处通过代理类或者被代理类获取到的类加载器都是同一个，或通过任何一个类获取到的类加载器都是同一个。）
        ClassLoader classLoader = this.getClass().getClassLoader();
        //第二个参数,被代理对象实现的所有接口数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //当通过代理类的对象发起对被重写的方法的调用时，都会转换为对如下的invoke方法的调用
        //代理实例的调用处理程序
        //第三个参数InvocationHandler的实现类,这里用了匿名内部类的方式
        InvocationHandler invocationHandler = new InvocationHandler() {
            //重写InvocationHandler的invoke方法,他有三个参数可以供我们使用
            @Override
            public Object invoke(Object proxy, Method method, Object[] args){
                /**
                 * proxy：表示代理对象
                 * method：表示要执行的方法（代理对象需要实现的抽象方法，即其中需要重写的 和目标类同名的方法）
                 * args：表示要执行的方法的参数列表（method所对应方法的参数列表）
                 */
                Object result = null;
                try {
                    //method.getName(): 返回此method对象表示的方法的名称，作为字符串
                    System.out.println("[jdk动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                    //通过反射调用method对象所表示的方法,并获取该方法的返回值
                    //在具有指定参数的指定对象上调用此method对象表示的底层方法。
                    //此处就是通过target来确定调用的是具体哪个类中的方法
                    result = method.invoke(target, args);
                    System.out.println("[jdk动态代理][日志] "+method.getName()+"，结 果："+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[jdk动态代理][日志] "+method.getName()+"，异常："+e.getMessage());
                } finally {
                    System.out.println("[jdk动态代理][日志] "+method.getName()+"，方法执行完毕");
                }
                return result;
            }
        };
        //返回指定接口的代理类的实例，该实例将方法调用分派给指定的调用处理程序。
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
