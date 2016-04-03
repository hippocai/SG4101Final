package com.ft9.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	/**
	 * insert at the head of the file
	 */
	final public static int APPEND=1;
	/**
	 * insert at the end of the file
	 */
	final public static int PREPEND=2;
	/**.
	 * cover the original file
	 */
	final public static int WRITENEW=3;
	    
	    
    private BufferedReader bufread;
    private String path = "";
    private File file=null;
    
    public FileUtil(String filePath) throws IOException{
    	this.path=filePath;
    	file=new File(path);
    	 if (!file.exists()) {
             file.createNewFile();
             log.info(file + "Created！");
         }
    	
    }

    
    
    /**
     * 
     * @return
     */
    public boolean checkFileExists(){
    	return file.exists();
    }
    /**
     * readWholeFileToString
     * 
     */
    public String readWholeFile()throws IOException,FileNotFoundException{
        String readedLine="";
        String content="";
        FileReader fileread;
        fileread = new FileReader(file);
        bufread = new BufferedReader(fileread);
        int lineNumber=0;
        while ((readedLine = bufread.readLine()) != null) {
        	if(lineNumber!=0){
        		content+="\r\n";
        	}
            content+= readedLine;
            ++lineNumber;
        }
       
        return content;
    }
    /**
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public List<String>readWholeFileSplitToList() throws FileNotFoundException, IOException{
    	List<String>fileLines=new ArrayList<String>();
    	String[]linesArray=readWholeFile().split("\r\n");
    	for(String line:linesArray){
    		fileLines.add(line);
    	}
    	return fileLines;
    }
    /**
     * 写文件.
     * Write To File
     */
    public boolean writeToFile(String newStr,int writeType) throws IOException{
    	String fileContent=readWholeFile();
    	if(fileContent.equals("")){
    		fileContent=newStr;
    	}else{
    		switch(writeType){
	    		case PREPEND:fileContent= newStr + "\r\n" + fileContent;break;
	    		case APPEND:fileContent=fileContent+"\r\n"+newStr;break;
	    		case WRITENEW:fileContent=newStr;break;
	    		default:log.error("Error WriteType!");return false;
    		}
    	}
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(file, "rw");
            mm.writeBytes(fileContent);
            return true;
        } catch (IOException e1) {
            e1.printStackTrace();
            return false;
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    /**
     * 删除某一行
     * delete a line
     * @param row2Delete
     * @return
     */
    public boolean deleteRow(String row2Delete){
    	  String temp = "";
          try {
              File file = new File(path);
              FileInputStream fis = new FileInputStream(file);
              InputStreamReader isr = new InputStreamReader(fis);
              BufferedReader br = new BufferedReader(isr);
              StringBuffer buf = new StringBuffer();

              while ((temp = br.readLine()) != null&& !temp.equals(row2Delete) ) {
                  buf = buf.append(temp);
                  buf = buf.append(System.getProperty("line.separator"));
              }

            
              boolean firstLineAfterDelete=true;
              while ((temp = br.readLine()) != null) {
            	  if(!firstLineAfterDelete){
            		  buf = buf.append(System.getProperty("line.separator"));
            	  }
                  buf = buf.append(temp);
                  firstLineAfterDelete=false;
              }

              br.close();
              FileOutputStream fos = new FileOutputStream(file);
              PrintWriter pw = new PrintWriter(fos);
              pw.write(buf.toString().toCharArray());
              pw.flush();
              pw.close();
              return true;
          } catch (IOException e) {
              e.printStackTrace();
              return false;
          }
    }
    public boolean replaceRowByStr(String oldStr,String replaceStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            while((temp = br.readLine()) != null
                    && !temp.equals(oldStr)) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            buf = buf.append(replaceStr);

            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
