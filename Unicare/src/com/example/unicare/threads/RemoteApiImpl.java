package com.example.unicare.threads;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;

import android.util.Log;

import com.example.unicare.common.HttpUtils;
import com.example.unicare.common.PropertiesUtils;

public class RemoteApiImpl {

	/**
	 * 请求登录
	 * 
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject userLogin(JSONObject sendData) throws Exception {
		String url = PropertiesUtils.getApi("login");
		JSONObject jsonData = HttpUtils.sendJSONPost(url, sendData);
		return jsonData;
	}

	/**
	 * 获取验证码
	 */

	public static JSONObject getsms(JSONObject sendData) throws Exception {
		String url = PropertiesUtils.getApi("getsms");
		Log.d("JSON", sendData.toString());
		JSONObject jsonData = HttpUtils.sendJSONPost(url, sendData);
		return jsonData;

	}
	public static JSONObject getmonAnalysisList(JSONObject sendData) throws Exception {
		String url = PropertiesUtils.getApi("monAnalysisList");
		Log.d("JSON", sendData.toString());
		JSONObject jsonData = HttpUtils.sendJSONPost(url, sendData);
		return jsonData;

	}

}