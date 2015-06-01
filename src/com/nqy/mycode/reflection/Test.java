package com.nqy.mycode.reflection;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Map;
import com.nqy.mycode.reflection.Test2.MyAnnotation;

/**
 * Created by abner on 5/27/15.
 */
public class Test extends Parent {
    private int i;
    private String s;
    public static float mFloat;
    public float f;
    public Map<Integer,String> map;

    public Test(String name){
        s = name;
    }

    public Test(){

    }

    private Test(int i,String s){
        this.i = i;
        this.s = s;
    }


    private static void sK(){
        System.out.println("this is static method sK");
    }

    public static void main(String[] args) {
        Class clazz = Test.class;

        Class cla = Test2.class;

        try {
            Method m = cla.getMethod("getStringList",null);
            System.out.println(m.getReturnType());
            Type type = m.getGenericReturnType();
            if(type instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] types = parameterizedType.getActualTypeArguments();
                for(Type typeArgument:types){
                    Class typeArgClass = (Class) typeArgument;
                    System.out.println(typeArgClass);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

//        try {
//            Method m = cla.getMethod("sayPublic",String.class,int.class);
//            Annotation[][] annotations = m.getParameterAnnotations();
//            Class[] parameterTypes =  m.getParameterTypes();
//
//            int i=0;
//            for(Annotation[] annotation : annotations){
//                Class parameterType = parameterTypes[i++];
//                for(Annotation annotation1:annotation){
//                    if(annotation1 instanceof MyAnnotation){
//                        MyAnnotation myAnnotation = (MyAnnotation) annotation1;
//                        System.out.println("param "+parameterType);
//                        System.out.println("key:"+myAnnotation.key());
//                        System.out.println("value:"+myAnnotation.value());
//                    }
//                }
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        try {
//            Method m = cla.getDeclaredMethod("say2",null);
//            Annotation annotation = m.getAnnotation(MyAnnotation.class);
//            if(annotation instanceof MyAnnotation){
//                MyAnnotation myAnnotation = (MyAnnotation) annotation;
//                System.out.println(myAnnotation.key());
//                System.out.println(myAnnotation.value());
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        try {
//            Method m = cla.getMethod("sayPublic",null);
//            m.invoke(cla.getConstructor(null).newInstance(null),null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        try {
//            Method m = cla.getDeclaredMethod("say2",null);
//            m.setAccessible(true);
//            m.invoke(cla.getConstructor(null).newInstance(null),null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        try {
//            Method m = clazz.getDeclaredMethod("sK",null);
//            m.invoke(null,null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


//        try {
//            Method m = clazz.getMethod("sayHi",new Class[]{int.class});
//            System.out.println(m.getParameterTypes()[0]);
//            System.out.println(m.getReturnType());
//            m.invoke(clazz.getConstructor(String.class).newInstance("kkk"),4);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }

//        try {
//            Field f = clazz.getDeclaredField("mFloat");
//            System.out.println(f.get(null));
//            f.set(null,5);
//            System.out.println(f.get(null));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        Test2 t = new Test2();
//        try {
//            Field f = t.getClass().getDeclaredField("p");
//            f.setAccessible(true);
//            System.out.println(f.get(t));
//            f.set(t,"m");
//            System.out.println(f.get(t));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        Field[] fields = clazz.getFields();
//        for(Field field:fields){
//            System.out.println(field.getName()+","+field.getType());
//        }

//        try {
//            Constructor c = clazz.getDeclaredConstructor(int.class,String.class);
//            Class[] pts = c.getParameterTypes();
//            for(Class p : pts){
//                System.out.println(p.getName());
//            }
//
//            Test t = (Test) c.newInstance(7,"five");
//            t.sayHi();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


//        Annotation[] annotation = clazz.getAnnotations();
//        for(Annotation a:annotation){
//            System.out.println(a.annotationType());
//        }

//        Class[] interfaces = clazz.getInterfaces();
//        for(Class i:interfaces){
//            System.out.println(i.getName());
//        }

//        Package p = clazz.getPackage();
//        System.out.println(p.getName());
//        System.out.println(p.getSpecificationVersion());

//        int modifier = clazz.getModifiers();
//        System.out.println(Modifier.isAbstract(modifier));
//        System.out.println(Modifier.isInterface(modifier));
//        System.out.println(Modifier.isPublic(modifier));
    }

    private static int[] changeOrder(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        return  arr;
    }

    public static void main2(String[] args) {

        /**
         * 2 ways to get Class instance
         */
        Class<Test> clazz = Test.class;
        System.out.println(clazz.getName());

        Test test = new Test();
        Class clazz2 =  test.getClass();
        System.out.println(clazz2.getName());

        System.out.println(clazz.toString());

        /**
         * getSuperclass
         */
        System.out.println(clazz.getSuperclass().getName());

        /**
         * get constructor
         */
        //only get public constructor
        System.out.println("--------getConstructors()---------");
        Constructor<Test>[] cs = (Constructor<Test>[]) clazz.getConstructors();
        for(Constructor<Test> c:cs){
            System.out.println("Constructor:"+c.getName());
        }
        //get all constructor
        System.out.println("--------getDeclaredConstructors()---------");
        cs = (Constructor<Test>[]) clazz.getDeclaredConstructors();
        for(Constructor<Test> c:cs){
            System.out.println("Constructor:"+c.getName());
            Class<?>[] ps = c.getParameterTypes();
            for(Class p:ps){
                System.out.println("param:"+p.getName());
            }
        }
        //get constructor with param
        try {
            Constructor cr = clazz.getDeclaredConstructor(int.class,String.class);
            System.out.println(cr.getModifiers());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * get method
         */
        System.out.println("---------get method-------");
        Method[] methods = clazz.getMethods();
        methods = clazz.getDeclaredMethods();
        try {
            Method method = clazz.getDeclaredMethod("sayHi",null);
            method.invoke(clazz);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void sayHi(int i){
        System.out.println("hi,i'm Test,my id is "+i+","+s);
    }

}

class Parent implements Serializable,Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
