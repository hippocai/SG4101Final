/*
 * All rights Reserved, Copyright (C) GElement LIMITED 2015
 * FileName: ClassUtils.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name           |      Content
 * 1   | 2015�?12�?19�?        | China)caiyicheng  | original version
 */
package com.ft9.util;

/**
 * class name:ClassUtils <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2015�?12�?19�?
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

        // ��һ��class��ļ���
        List<Class> classes = new ArrayList<Class>();
        // �Ƿ�ѭ������
        boolean recursive = true;
        // ��ȡ�������� �������滻
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        // ����һ��ö�ٵļ��� ������ѭ�����������Ŀ¼�µ�things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(
                    packageDirName);
            // ѭ��������ȥ
            while (dirs.hasMoreElements()) {
                // ��ȡ��һ��Ԫ��
                URL url = dirs.nextElement();
                // �õ�Э�������
                String protocol = url.getProtocol();
           
                // ��������ļ�����ʽ�����ڷ�������
                if ("file".equals(protocol)) {
                
                    //System.err.println("file���͵�ɨ��");
                    // ��ȡ��������·��
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // ���ļ��ķ�ʽɨ���������µ��ļ� ����ӵ�������
                    return getClassesWithFile(pack);
                } else if ("jar".equals(protocol)) {
                    // �����jar���ļ�
                    // ����һ��JarFile
                	
                    JarFile jar;
                    try {
                        // ��ȡjar
                        jar = ((JarURLConnection) url.openConnection())
                                .getJarFile();
                        // �Ӵ�jar�� �õ�һ��ö����
                        Enumeration<JarEntry> entries = jar.entries();
                        // ͬ���Ľ���ѭ������
                        while (entries.hasMoreElements()) {
                            // ��ȡjar���һ��ʵ�� ������Ŀ¼ ��һЩjar����������ļ� ��META-INF���ļ�
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // �������/��ͷ��
                            if (name.charAt(0) == '/') {
                                // ��ȡ������ַ���
                                name = name.substring(1);
                            }
                            // ���ǰ�벿�ֺͶ���İ�����ͬ
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // �����"/"��β ��һ����
                                if (idx != -1) {
                                    // ��ȡ���� ��"/"�滻��"."
                                    packageName = name.substring(0, idx)
                                            .replace('/', '.');
                                }
                                // ������Ե�����ȥ ������һ����
                                if ((idx != -1) || recursive) {
                                    // �����һ��.class�ļ� ���Ҳ���Ŀ¼
                                    if (name.endsWith(".class")
                                            && !entry.isDirectory()) {
                                        // ȥ�������".class" ��ȡ����������
                                        String className = name.substring(
                                                packageName.length() + 1, name
                                                        .length() - 6);
                                        try {
                                            // ��ӵ�classes
                                            classes.add(Class
                                                    .forName(packageName + '.'
                                                            + className));
                                        } catch (ClassNotFoundException e) {
                                            // log
                                            // .error("����û��Զ�����ͼ����� �Ҳ��������.class�ļ�");
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        // log.error("��ɨ���û�������ͼʱ��jar����ȡ�ļ�����");
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