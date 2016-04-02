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
 * @author ��һ��
 *
 */
public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	/**
	 * ���ı�ǰ����
	 * insert at the head of the file
	 */
	final public static int APPEND=1;
	/**
	 * ���ı������
	 * insert at the end of the file
	 */
	final public static int PREPEND=2;
	/**.
	 * 0
	 * ����Դ�ļ�
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
             log.info(file + "Created��");
         }
    	
    }

    
    
    /**
     * ����ļ��Ƿ����
     * 
     * @return
     */
    public boolean checkFileExists(){
    	return file.exists();
    }
    /**
     * ��ȡ�ı��ļ�.
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
       
      //  log.info("�ļ�������:" + content);
        return content;
    }
    /**
     * ���ļ��ָ��ÿһ�У�����һ��list
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
     * д�ļ�.
     * Write To File
     */
    public boolean writeToFile(String newStr,int writeType) throws IOException{
    	String fileContent=readWholeFile();
        //�ȶ�ȡԭ���ļ����ݣ�Ȼ�����д�����
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
       // log.info("�µ��ļ������ǣ�"+fileContent);
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(file, "rw");
            mm.writeBytes(fileContent);
            return true;
        } catch (IOException e1) {
            // TODO �Զ����� catch ��
            e1.printStackTrace();
            return false;
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    // TODO �Զ����� catch ��
                    e2.printStackTrace();
                }
            }
        }
    }
    /**
     * ɾ��ĳһ��
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

              // �������ǰ�������
              while ((temp = br.readLine()) != null&& !temp.equals(row2Delete) ) {
                  buf = buf.append(temp);
                  buf = buf.append(System.getProperty("line.separator"));
              }

            
              boolean firstLineAfterDelete=true;
              // ������к��������
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
     * ���ļ���ָ�����ݵĵ�һ���滻Ϊ��������.
     * 
     * @param oldStr
     *            ��������
     * @param replaceStr
     *            �滻����
     */
    public boolean replaceRowByStr(String oldStr,String replaceStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // �������ǰ�������
            while((temp = br.readLine()) != null
                    && !temp.equals(oldStr)) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // �����ݲ���
            buf = buf.append(replaceStr);

            // ������к��������
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
//				System.out.println("��"+(i+1)+"�У�"+lines.get(i));
//			}
//		} catch (IOException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//
//    }
}
