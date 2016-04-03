package com.ft9.util;

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

        List<Class> classes = new ArrayList<Class>();
        boolean recursive = true;
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(
                    packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    return getClassesWithFile(pack);
                } else if ("jar".equals(protocol)) {
                	
                    JarFile jar;
                    try {
                        jar = ((JarURLConnection) url.openConnection())
                                .getJarFile();
                        Enumeration<JarEntry> entries = jar.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            if (name.charAt(0) == '/') {
                                name = name.substring(1);
                            }
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                if (idx != -1) {
                                    packageName = name.substring(0, idx)
                                            .replace('/', '.');
                                }
                                if ((idx != -1) || recursive) {
                                    if (name.endsWith(".class")
                                            && !entry.isDirectory()) {
                                        String className = name.substring(
                                                packageName.length() + 1, name
                                                        .length() - 6);
                                        try {
                                            classes.add(Class
                                                    .forName(packageName + '.'
                                                            + className));
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
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