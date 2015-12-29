package util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Util {
	
	public static String readStringFromInputStream(InputStream inputStream){
		String result = null;
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int b = -1;
			while((b=inputStream.read())!=-1){
				bos.write(b);
			}
			inputStream.close();
			result = new String(bos.toByteArray());
			bos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static String readStringFromFile(String path){
		StringBuilder sb = new StringBuilder();
		try{
			List<String> lines = Files.readAllLines(Paths.get(path));
			for(String s : lines){
				sb.append(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
