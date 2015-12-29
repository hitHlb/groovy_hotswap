package util;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import util.Util;

public class HttpConnectionHelper {
	private static final String hostUrl = "http://localhost:10101/gs";
	private static final String path = "C:/GroovyTest.groovy"; //groovy脚本地址
	public static void main(String[] args){
		try{
			connectAndGet();			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过http post的方式通知服务器加载指定位置的groovy脚本
	 */
	public static void connectAndGet() throws Exception{
		StringBuilder param = new StringBuilder();
		param.append("code").append("=").append(path);
		
		URL url = new URL(hostUrl + param.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(2000);
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
		printWriter.write(param.toString());
		printWriter.flush();
		printWriter.close();
		
		String result = Util.readStringFromInputStream(connection.getInputStream());
		System.out.print(result);
	}
}
