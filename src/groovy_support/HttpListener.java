package groovy_support;

import handler.GroovyHandler;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class HttpListener {
	public static final String filter = "/gs";
	public static HttpListener getInstance(){
		return HttpListenerHolder.instance;
	}
	
	public void begin(){
		try{
			HttpServer httpServer = HttpServer.create(new InetSocketAddress(10101),0);
			httpServer.createContext(filter,new GroovyHandler());
			httpServer.setExecutor(null);
			httpServer.start();
			System.out.println("httpServer started");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static class HttpListenerHolder{
		private static HttpListener instance = new HttpListener();
	}
}
