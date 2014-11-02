package com.example.unicare.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.util.Log;


public class PropertiesUtils {
	/**
	 * 根据api名称得到api的ip
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getApi(String key) throws IOException{
		Properties props = new Properties();
		 // 加载资源文件,用相对路径,根目录/指的是包所在的目录
	    InputStream in = PropertiesUtils.class.getResourceAsStream(
	        "/assets/api.properties");
	    props.load(in); // 从流中读出键值对，直接加入到哈希表
	    in.close();
	    String value = props.get(key).toString();
	    return value;
	}
	
	/**
	 * 根据errorcode获得错误提示信息
	 * @param errorcode
	 * @return
	 * @throws IOException
	 */
	public static String getPrompt(int errorcode) throws IOException{
		Properties props = new Properties();
		 // 加载资源文件,用相对路径,根目录/指的是包所在的目录
	    InputStream in = PropertiesUtils.class.getResourceAsStream(
	        "/assets/errorcode.properties");
	    props.load(in); // 从流中读出键值对，直接加入到哈希表
	    in.close();
	    String value = props.get(String.valueOf(errorcode)).toString();
	    Log.d("value",""+value);
	    return new String(value.getBytes("ISO-8859-1"),"UTF8");
	}
}
