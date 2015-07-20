package com.nqy.mycode.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by abner on 7/20/15.
 */
public class DynamicProxiesExample {
    public static void main(String[] args) {
        ConcreteClass cc1 = new ConcreteClass();
        ConcreteClass2 cc2 = new ConcreteClass2();

        ProxyHandler ph1 = new ProxyHandler(cc1);
        TargetInterface ti1 = (TargetInterface) Proxy.newProxyInstance(TargetInterface.class.getClassLoader(), new Class[]{TargetInterface.class}, ph1);
        ti1.targetMethodA(1);
        ti1.targetMethodB(2);

        ProxyHandler ph2 = new ProxyHandler(cc2);
        TargetInterface ti2 = (TargetInterface) Proxy.newProxyInstance(cc2.getClass().getClassLoader(),cc2.getClass().getInterfaces(),ph2);
        ti2.targetMethodA(1);
        ti2.targetMethodB(2);
    }
}

class ProxyHandler implements InvocationHandler{
    Object concreteObj = null;

    public ProxyHandler(Object concreteObj){
        this.concreteObj = concreteObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getName());
        System.out.println("method:"+method.getName());
        System.out.println("args:"+args[0].getClass().getName());

        System.out.println("Before invoke method...");
        Object object=method.invoke(concreteObj, args);//普通的Java反射代码,通过反射执行某个类的某方法
        //System.out.println(((ConcreteClass)concreteClass).targetMethod(10)+(Integer)args[0]);
        System.out.println("After invoke method...");
        return object;
    }
}

interface TargetInterface {
    public int targetMethodA(int number);
    public int targetMethodB(int number);
}

class ConcreteClass implements TargetInterface{

    public int targetMethodA(int number) {
        System.out.println("ConcreteClass 开始调用目标类的方法targetMethodA...");
        System.out.println("ConcreteClass 操作-打印数字:"+number);
        System.out.println("ConcreteClass 结束调用目标类的方法targetMethodA...");
        return number;
    }

    public int targetMethodB(int number){
        System.out.println("ConcreteClass 开始调用目标类的方法targetMethodB...");
        System.out.println("ConcreteClass 操作-打印数字:"+number);
        System.out.println("ConcreteClass 结束调用目标类的方法targetMethodB...");
        return number;
    }

}

class ConcreteClass2 implements TargetInterface{

    public int targetMethodA(int number) {
        System.out.println("ConcreteClass2 开始调用目标类的方法targetMethodA...");
        System.out.println("ConcreteClass2 操作-打印数字:"+number);
        System.out.println("ConcreteClass2 结束调用目标类的方法targetMethodA...");
        return number;
    }

    public int targetMethodB(int number){
        System.out.println("ConcreteClass2 开始调用目标类的方法targetMethodB...");
        System.out.println("ConcreteClass2 操作-打印数字:"+number);
        System.out.println("ConcreteClass2 结束调用目标类的方法targetMethodB...");
        return number;
    }

}