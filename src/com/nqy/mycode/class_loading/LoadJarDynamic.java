package com.nqy.mycode.class_loading;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by abner on 8/5/15.
 */
public class LoadJarDynamic {
    public static void main(String[] args) {
        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);

        try {
            classLoader.addJar(new File("/home/abner/workspace_idea_intellij/work_project/out/artifacts/JavaUtil/JavaUtil.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("com.nqy.Util");
            Method method = clazz.getDeclaredMethod("getVersion");
            method.invoke(null);
//            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public void addJar(URL url) {
            this.addURL(url);
        }

    }
}
