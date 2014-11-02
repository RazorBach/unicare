package com.example.unicare.threads;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.unicare.activity.MainActivity;
import com.example.unicare.threads.RemoteApiImpl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * 登录线程
 * 
 * @author he
 * 
 */
public class ThreadUtil implements Runnable {
	// ---------注册登录模块-------------------//
	public static final int REGISTER = 0;
	public static final int LOGIN = 1;
	public static final int MonAnalysisList=3;
	

	private Handler handler;
	private JSONObject sendData;
	int action;

	public ThreadUtil(Handler handler, JSONObject sendData, int action) {
		super();
		this.handler = handler;
		this.sendData = sendData;
		this.action = action;
	}

	@Override
	public void run() {
		Bundle bundle = new Bundle();
		Message msg = new Message();
		try {
			JSONObject jsonData = request(action);
			if (jsonData != null) {
				try {
					String e1 = jsonData.getString("nulldata");
					Log.e("nulldata", e1);
					msg.what = -1;
				} catch (JSONException je1) {
					// 说明jsonData中不存在"nulldata"
					try {
						String e2 = jsonData.getString("sendfail");
						bundle.putString("sendfail", e2);
						msg.what = 0;
					} catch (JSONException je2) {
						// 说明jsonData中不存在"sendfail"
						// 获取数据成功，返回数据给主线程
						bundle.putString("data", jsonData.toString());
						msg.setData(bundle);
						msg.what = 1;
					}
				}
			} else {
				Log.e("jdNull", "jsonData为空");
				msg.what = -2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("connException", "连接服务器失败,请检查网络");
			msg.what = -3;
		} finally {
			msg.setData(bundle);
			handler.sendMessage(msg);
		}
	}

	/**
	 * 根据action执行相应的线程
	 * 
	 * @param action
	 * @return
	 * @throws Exception
	 */
	private JSONObject request(int action) throws Exception {
		switch (action) {
		// ---------注册登录模块-------------------//
		
		case LOGIN:
			return RemoteApiImpl.userLogin(sendData);
		case MonAnalysisList:
			return RemoteApiImpl.getmonAnalysisList(sendData);
		default:
			return null;
		}
	}
}
