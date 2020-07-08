package com.gaemi.wiw.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtility {
	
	private static final String PATH_STRING = "C:\\What_I_Watched\\WhatIWatched\\src\\main\\webapp\\resources\\upload";
	
	public static String saveFile(MultipartFile uploadFile) {
		
		String originalFileName = uploadFile.getOriginalFilename();
		String fileExtention = getFileExtention(originalFileName);
		
		String newFileName = getNewFileName() + fileExtention;
		
		File file = new File( PATH_STRING , newFileName );
		
		try {
			FileUtils.writeByteArrayToFile(file, uploadFile.getBytes());
			return newFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String getFileExtention(String originalFileName) {
		String fileExtention = originalFileName.substring(originalFileName.lastIndexOf((".")));
		return fileExtention;
	}
	
	public static String getNewFileName() {		
		String fileName = UUID.randomUUID().toString();
		return fileName;
	}
}
