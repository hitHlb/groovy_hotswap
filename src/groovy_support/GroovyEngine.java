package groovy_support;

import java.io.File;
import java.io.IOException;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

public class GroovyEngine {
	public static GroovyEngine getInstance(){
		return GroovyEngineHolder.groovyEngine;
	}
	
	/**
	 * 加载脚本
	 * @param code
	 */
	public Object exec(String codePath){
		Object result = null;
		GroovyClassLoader groovyClassLoader = new GroovyClassLoader(GroovyEngine.class.getClassLoader());
		try{
			Class<?> groovyClass = groovyClassLoader.parseClass(new File(codePath));
			GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
			result = groovyObject.invokeMethod("run",null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			groovyClassLoader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static class GroovyEngineHolder{
		private static GroovyEngine groovyEngine = new GroovyEngine();
	}
}
