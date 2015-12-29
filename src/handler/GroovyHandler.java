package handler;

import groovy_support.GroovyEngine;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import util.Util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GroovyHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange paramHttpExchange) throws IOException {
		//不支持get,因为url参数有格式限制
		if(paramHttpExchange.getRequestMethod().equalsIgnoreCase("POST")){
			InputStream is = paramHttpExchange.getRequestBody();
			String code = Util.readStringFromInputStream(is);
			
			Object o = GroovyEngine.getInstance().exec(code.substring("code=".length()));
			paramHttpExchange.sendResponseHeaders(200, o.toString().length());
			OutputStream os = paramHttpExchange.getResponseBody();
			os.write(o.toString().getBytes());
			os.flush();
			os.close();
		}
	}
}
