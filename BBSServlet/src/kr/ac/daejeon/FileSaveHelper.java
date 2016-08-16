package kr.ac.daejeon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSaveHelper {
	
	public static void save(String fileName, InputStream is) throws IOException {
		
		String saveDir = "d:/upload/";
		File file = new File(saveDir + fileName);
		System.out.println(file.getAbsolutePath());
		FileOutputStream os = null;
		
		os = new FileOutputStream(file);
		
		int temp = -1;
		while ((temp = is.read()) != -1) {
			os.write(temp);
		}
		
		is.close();
		os.close();
		
	}

}
