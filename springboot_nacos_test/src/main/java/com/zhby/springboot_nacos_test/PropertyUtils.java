package com.zhby.springboot_nacos_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;


@Component
public class PropertyUtils {

	@Autowired
    private Environment env;
	
	private static PropertyUtils that;
	 
	@PostConstruct //@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行
	public void init() {
		that = this;
		that.env = this.env;
	}

	public static String getProperty(String key) {
		return that.env.getProperty(key);

	}
	
	public static String getResourceBasePath(){
		return PropertyUtils.getProperty("web.upload-path");
/*		
		Resource resource = new ClassPathResource("");
		try {
			return resource.getFile().getAbsolutePath();
		} catch (IOException e) {
			return "";
		}*/
	}
	
	public static String getRealPath(HttpServletRequest request){
		return PropertyUtils.getProperty("web.upload-path");
		//return request.getSession().getServletContext().getRealPath("/");
	}
	
	
}
