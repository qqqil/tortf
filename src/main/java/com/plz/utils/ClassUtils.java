package com.plz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by andy on 17-4-6.
 */
public class ClassUtils {

    static Logger logger = LoggerFactory.getLogger(ClassUtils.class);
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }
    /**
     *  获得pkg下所有classes
     * @param pkg
     * @return
     */
    public static List<Class<?>> getClassesList(String pkg) throws IOException {
        Enumeration<URL> urls = getClassLoader().getResources(pkg);
        List<Class<?>> classList = new LinkedList<>();
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            String protocol = url.getProtocol();
            if(protocol.equals("file")){
                String path = url.getPath();
                logger.info(path);
                addClasses(classList,path,pkg);
            }else if(protocol.equals("jar")){
                JarFile jarFile = new JarFile(url.getFile());
                Enumeration<JarEntry> entryEnum = jarFile.entries();
                while (entryEnum.hasMoreElements()){
                    JarEntry entry = entryEnum.nextElement();
                    String clzzname = entry.getName();
                    if(clzzname.endsWith(".class")) {
                        loadClass(clzzname);
                    }
                }
            }
        }
        return classList;
    }

    /**
     * 加载class
     * @param classList
     * @param path
     * @param pkg
     */
    public static void addClasses(List<Class<?>> classList,String path,String pkg){
        File[] files = new File(path).listFiles(pathname -> pathname.getPath().endsWith(".class") || pathname.isDirectory());

        for(File f: files){
            if(f.isFile()){
                String clzPath = pkg+"."+f.getName();
                String clzName = clzPath.substring(0,clzPath.lastIndexOf(".")).replaceAll("/",".");
                Class<?> clzz = loadClass(clzName);
                if(clzz != null){
                    classList.add(clzz);
                }
            }else{
                String subDir = f.getPath();
                addClasses(classList,subDir,pkg+"."+f.getName());
            }
        }
    }
    public static Class<?> loadClass(String classname){
        try {
            if(classname.endsWith(".class")){
                classname = classname.substring(0,classname.lastIndexOf("."));
            }
            logger.info(classname);
            return Class.forName(classname);
        } catch (ClassNotFoundException e) {
            logger.error(e.getLocalizedMessage());
        }
        return null;
    }
}
