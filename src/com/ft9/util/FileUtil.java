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


/**
 * @author 蔡一诚
 *
 */
public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	/**
	 * 在文本前插入
	 * insert at the head of the file
	 */
	final public static int APPEND=1;
	/**
	 * 在文本后插入
	 * insert at the end of the file
	 */
	final public static int PREPEND=2;
	/**.
	 * 0
	 * 覆盖源文件
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
     * 检查文件是否存在
     * 
     * @return
     */
    public boolean checkFileExists(){
    	return file.exists();
    }
    /**
     * 读取文本文件.
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
       
      //  log.info("文件内容是:" + content);
        return content;
    }
    /**
     * 将文件分割成每一行，放入一个list
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
        //先读取原有文件内容，然后进行写入操作
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
       // log.info("新的文件内容是："+fileContent);
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(file, "rw");
            mm.writeBytes(fileContent);
            return true;
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            e1.printStackTrace();
            return false;
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    // TODO 自动生成 catch 块
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

              // 保存该行前面的内容
              while ((temp = br.readLine()) != null&& !temp.equals(row2Delete) ) {
                  buf = buf.append(temp);
                  buf = buf.append(System.getProperty("line.separator"));
              }

            
              boolean firstLineAfterDelete=true;
              // 保存该行后面的内容
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
    /**
     * 将文件中指定内容的第一行替换为其它内容.
     * 
     * @param oldStr
     *            查找内容
     * @param replaceStr
     *            替换内容
     */
    public boolean replaceRowByStr(String oldStr,String replaceStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该行前面的内容
            while((temp = br.readLine()) != null
                    && !temp.equals(oldStr)) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // 将内容插入
            buf = buf.append(replaceStr);

            // 保存该行后面的内容
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
//    public static void main(String[] s)  {
//    	FileUtil fileUtil=new FileUtil("D:\\123.txt");
//    	try {
//    	
//			fileUtil.creatFile();
//			//fileUtil.writeToFile("XIJINGP", FileUtil.PREPEND);
//	    	//fileUtil.writeToFile("YaMei", FileUtil.APPEND);
//    		//fileUtil.deleteRow("XIJINGP");
//    		//fileUtil.replaceRowByStr("YaMei", "WenJiaBao");
//			List<String> lines=fileUtil.readWholeFileSplitToList();
//			for(int i=0;i<lines.size();++i){
//				System.out.println("第"+(i+1)+"行："+lines.get(i));
//			}
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//
//    }
}
