package com.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadAction {
	private File tx;//上传的临时文件，保存在tomcat目录之中
	private String txFileName;//文件名称，约定熟成的名字前
	
	
	public void setTx(File tx) {
		this.tx = tx;
	}


	public void setTxFileName(String txFileName) {
		this.txFileName = txFileName;
	}


	@SuppressWarnings("deprecation")
	public String upload() {
		System.out.println(tx);
		System.out.println(txFileName);
		//获取上传路径(上传到缓冲文件夹的路径)tomcat中的缓存文件夹
		String realPath = ServletActionContext.getRequest().getRealPath("tap");
		//设置缓冲文件()
		File file = new File(realPath+"/"+txFileName);
		//判断文件夹是否存在,若不存在，则创建
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		//上传文件，判断文件是否为空
		if(tx==null) {
			return "error";
		}
		//对上传文件大小的限制
		if(tx.length()>1024*1024*20) {
			return "error";
		}
		//对上传文件的格式进行限制
		String [] str = {"doc","jpg","gif","png"};
		boolean qu =false;
		for (String s : str) {
			if(txFileName.endsWith(s)) {
				qu = true;
				break;
			}
		}
		if(!qu) {
			return"error";
		}
		//上传文件到缓冲文件中
		try {
			FileUtils.copyFile(tx, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//在缓冲文件中拷贝到目标文件夹
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[]by = new byte[(int)file.length()];
			fis.read(by);
			fis.close();
			long time = System.currentTimeMillis();
			FileOutputStream fos = new FileOutputStream("D:/pppp/"+time+txFileName);
			fos.write(by);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
