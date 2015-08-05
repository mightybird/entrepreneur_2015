package org.sicdlab.entrepreneur.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;


public class FileUpload {
	   public static String uploadFile(String fileuploadFileName,String savePath,File fileupload ) {  
		 	
	        String extName = ""; // 保存文件拓展名  
	        String newFileName = ""; // 保存新的文件名  
	        String nowTimeStr = ""; // 保存当前时间   
	        SimpleDateFormat sDateFormat;  
	        Random r = new Random();  
	       
	        // 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）  
	        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数  
	        sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间格式化的格式  
	        nowTimeStr = sDateFormat.format(new Date()); // 当前时间  
	        // 获取拓展名  
	        if (fileuploadFileName.lastIndexOf(".") >= 0) 
	        {  
	            extName = fileuploadFileName.substring(fileuploadFileName.lastIndexOf("."));  
	        }  
	        try {  
	            newFileName = nowTimeStr + rannum + extName; // 文件重命名后的名字  
	            String filePath = savePath +"\\"+ newFileName;  
	            filePath = filePath.replace("//", "/");  
	            System.out.println(filePath+"吧图片复制到哪个路径");
	            //检查上传的是否是图片  
	            if (UtilCommon.checkIsImage(extName)) 
	            {  
	            	System.out.println("图片复制了！");
	            	FileUtils.copyFile(fileupload, new File(filePath));
	                return filePath;  
	            }
	            else 
	            {  
	            	return "FILE_TYPE_ERROR";  
	            }  
	          
	        } catch (IOException e) {  
	            e.printStackTrace(); 
	            return "FILE_UPLOAD_ERROR";    
	        }
	    }    
	   
	   public static class UtilCommon {  
		    public static String getSerial(Date date, int index) {  
		        long msel = date.getTime();  
		        SimpleDateFormat fm = new SimpleDateFormat("MMddyyyyHHmmssSS");  
		        msel += index;  
		        date.setTime(msel);  
		        String serials = fm.format(date);  
		        return serials;  
		    }  
		    // 检查是否是图片格式  
		    public static boolean checkIsImage(String imgStr) {  
		        boolean flag = false;  
		        if (imgStr != null) {  
//		            if (imgStr.equalsIgnoreCase(".gif")  
//		                    || imgStr.equalsIgnoreCase(".jpg")  
//		                    || imgStr.equalsIgnoreCase(".jpeg")  
//		                    || imgStr.equalsIgnoreCase(".png")) {  
		                flag = true;  
		            //}  
		        }  
		        return flag;  
		    }  
		}  
}
