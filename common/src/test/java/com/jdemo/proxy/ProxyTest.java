package com.jdemo.proxy;

import com.jdemo.proxy.bean.ProxyDemo;
import com.jdemo.proxy.bean.ProxyDemo2;
import com.jdemo.proxy.bean.ProxyDemo2Impl;
import org.junit.Test;

/**
 * @Description TODO
 * @Date 2024/2/27 15:19
 */
public class ProxyTest {
    @Test
    public void cdlibTest(){
        ProxyDemo demo = new ProxyDemo();
        /* proxy就是我们创建的代理对象，这个对象可以执行被代理类中所有的方法，
        并且我们可以在代理对象中对被代理类的方法进行增强，
        注意这里使用了强转，因为getProxy方法的返回值是Object类型的对象*/
        ProxyDemo proxy = (ProxyDemo)CglibProxy.getProxy(demo);
        proxy.demo();
    }

    @Test
    public void JDKTexst(){
        JDKProxy demo = new JDKProxy(new ProxyDemo2Impl());
        ProxyDemo2 proxy = (ProxyDemo2) demo.getProxy();
        //创建好了代理对象,代理对象就可以执行被代理类实现的接口的方法；当通过代理类的对象发起对被重写的方法的调用时，都会转换为对调用处理器实现类中的invoke方法的调用，invoke方法中就可以对被代理类进行功能增强.
        proxy.demo();
    }
}

