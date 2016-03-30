/*
 * All rights Reserved, Copyright (C) GElement LIMITED 2015
 * FileName: ClassUtils.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name           |      Content
 * 1   | 2015骞?12鏈?19鏃?        | China)caiyicheng  | original version
 */
package com.ft9.util;

/**
 * class name:ClassUtils <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2015骞?12鏈?19鏃?
 * @author GElement)caiyicheng
 */
import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

 
public class ClassUtils {
     
     
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Class> getAllClassByInterface(Class c){
        List<Class> returnClassList = new ArrayList<Class>();
         
        if(c.isInterface()){
            String packageName = c.getPackage().getName();
            try{
                List<Class> allClass = getClasses(packageName);
                for(int i=0; i<allClass.size(); i++){
                    if(c.isAssignableFrom(allClass.get(i))){
                        if(!c.equals(allClass.get(i))){
                            returnClassList.add(allClass.get(i));
                        }
                    }
                }
            }catch(ClassNotFoundException e){
                e.printStackTrace();
             
            }
        }
        return returnClassList;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Class> getAllClassByFatherClass(Class c,String packageName){
        List<Class> returnClassList = new ArrayList<Class>();
         
        
            //String packageName = c.getPackage().getName();
            try{
                List<Class> allClass = getClasses(packageName);
                for(int i=0; i<allClass.size(); i++){
                    if(c.isAssignableFrom(allClass.get(i))){
                        if(!c.equals(allClass.get(i))){
                            returnClassList.add(allClass.get(i));
                        }
                    }
                }
            }catch(ClassNotFoundException e){
                e.printStackTrace();
               
            }
        
        return returnClassList;
    }
     
     
     
     
     
    @SuppressWarnings("rawtypes")
	public static List<Class> getClassesWithFile(String packageName) throws ClassNotFoundException,IOException{
         
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
         
        Enumeration<URL> resources = classLoader.getResources(path);
        
        List<File> dirs = new ArrayList<File>();
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
           
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
       
        for(File directory :dirs){
            classes.addAll(findClasses(directory,packageName));
        }
        return classes;
    }
     
    @SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory,String packageName) throws ClassNotFoundException{
         
        List<Class> classes = new ArrayList<Class>();
        if(!directory.exists()){
            return classes;
        }
         
        File[] files = directory.listFiles();
       
        for(File file : files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,packageName+"."+file.getName()));
            }else if(file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName+"."+file.getName().substring(0,file.getName().length() -6)));
            }
        }
        return classes;
    }
    
    public static List<Class> getClasses(String pack) throws ClassNotFoundException {

        // 第一个class类的集合
        List<Class> classes = new ArrayList<Class>();
        // 是否循环迭代
        boolean recursive = true;
        // 获取包的名字 并进行替换
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(
                    packageDirName);
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
           
                // 如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                
                    //System.err.println("file类型的扫描");
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    return getClassesWithFile(pack);
                } else if ("jar".equals(protocol)) {
                    // 如果是jar包文件
                    // 定义一个JarFile
                	
                    JarFile jar;
                    try {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection())
                                .getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/') {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx)
                                            .replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class")
                                            && !entry.isDirectory()) {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(
                                                packageName.length() + 1, name
                                                        .length() - 6);
                                        try {
                                            // 添加到classes
                                            classes.add(Class
                                                    .forName(packageName + '.'
                                                            + className));
                                        } catch (ClassNotFoundException e) {
                                            // log
                                            // .error("添加用户自定义视图类错误 找不到此类的.class文件");
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        // log.error("在扫描用户定义视图时从jar包获取文件出错");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }
     
}