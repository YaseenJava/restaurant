package com.fastfood.restaurants;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;

public class productFile {

	@Autowired
	ProductRepository productrepo;
	
	public String save(MultipartFile file) {
		
		String filename;
		filename=file.getOriginalFilename();
		
		if(filename!=null) {
			 try{
				  File saveFile=new ClassPathResource("static/img").getFile();
				//  Path path=Paths.get(saveFile.getAbsolutePath()+File.pathSeparator+file.getOriginalFilename());
				  Path path = saveFile.toPath().resolve(file.getOriginalFilename());
				//  Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				  Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				  System.out.print(path);
				  
				  System.out.println("allah uh akbar");
			  }
				  catch(Exception e) {
					  e.printStackTrace();
				  }

		}
		
		return filename;
	}
	
	 
}
