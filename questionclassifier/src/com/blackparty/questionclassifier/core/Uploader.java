
package com.blackparty.questionclassifier.core;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.blackparty.models.User;

public class Uploader {
	private String dataDirectory = System.getProperty("catalina.base")+"/User";
	
	private boolean flag = false;
	
	
	public Uploader(){
		dataDirectoryValidate();	
	}
	public boolean dataDirectoryValidate(){
		File f = new File(dataDirectory);
		if(!f.exists()){
			System.out.println("Cannot find directory for data.");
			f.mkdir();
			System.out.println("User directory created at "+dataDirectory );
		}
		return false;
	}

	
	public boolean upload(MultipartFile file,User user,String category) throws Exception{	
		byte[] bytes = file.getBytes();
		String userDirectory = dataDirectory+"/"+user.getUsername();
		userDirectoryValidate(userDirectory,user);
        userDirectory = dataDirectory+"/"+user.getUsername()+"/"+category;
		File f = new File(userDirectory+"/"+file.getOriginalFilename()+".pdf");
        FileOutputStream bos = new FileOutputStream(f);
		BufferedOutputStream stream = new BufferedOutputStream(bos);
        stream.write(bytes);
        stream.close();
        System.out.println("File uploaded at "+userDirectory);
		return flag;
	}
	public boolean userDirectoryValidate(String userDirectory,User user){
		File f = new File(userDirectory);
		if(!f.exists()){
			System.out.println("Cannot find directory for "+user.getUsername()+".");
			f.mkdir();
			System.out.println("Directory for "+user.getUsername()+" is created. at "+userDirectory);
			File f1 = new File(userDirectory+"/Knowledge");
			File f2 = new File(userDirectory+"/Process");
			File f3 = new File(userDirectory+"/Understanding");
			File f4 = new File(userDirectory+"/Product");
			f1.mkdir();
			System.out.println("Knowledge folder for "+user.getUsername()+" is created.");
			f2.mkdir();
			System.out.println("Process folder for "+user.getUsername()+" is created.");
			f3.mkdir();
			System.out.println("Understanding folder for "+user.getUsername()+" is created.");
			f4.mkdir();
			System.out.println("Product folder for "+user.getUsername()+" is created.");
		}
		return false;
	}
	
}
