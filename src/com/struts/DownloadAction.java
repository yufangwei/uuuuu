package com.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {
	
	private String fileName;
	private InputStream inputStream;
	@SuppressWarnings("deprecation")
	public String download() throws IOException {
		String realPath = ServletActionContext.getRequest().getRealPath("/download");
		File file1 = new File(realPath+"/"+fileName);
		if(!file1.getParentFile().exists()) {
			file1.getParentFile().mkdirs();
		}
		File file2 = new File("D:/pppp/"+fileName);
		FileInputStream fis = new FileInputStream(file2);
		byte[]b = new byte[(int)file2.length()];
		fis.read(b);
		fis.close();
		FileOutputStream fos = new FileOutputStream(file1);
		fos.write(b);
		fos.close();
		File file = new File(realPath,fileName);
		inputStream = new FileInputStream(file);
		return "success";
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
