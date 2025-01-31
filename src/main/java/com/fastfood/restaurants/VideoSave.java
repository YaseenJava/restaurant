package com.fastfood.restaurants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
public class VideoSave {
	
	//private static String dir="/static/";
	
	public String saveVideo(MultipartFile file) throws IOException {
		
		String name=file.getOriginalFilename();
		String content=file.getContentType();
		InputStream inputstream=file.getInputStream();
		;
		
		
		String cleanFileName =StringUtils.cleanPath(name);
		//String cleanFolder=StringUtils.cleanPath(dir);
		
		
		File saveFile=new ClassPathResource("static/video").getFile();
	    Path path = saveFile.toPath().resolve(file.getOriginalFilename());
		//Path path =Paths.get(cleanFolder,cleanFileName);
		System.out.print(path);
		
		Files.copy(inputstream,path,StandardCopyOption.REPLACE_EXISTING);
		
		return name;
	}

}
