package com.example.unicare.threads;

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

	// ID保持跟word的序号一样
	public static final int REGISTER = 0;
	public static final int LOGIN = 1;
	public static final int MONITOR_ALARM_INFO = 3;

	private Handler handler;
	private String sendData;
	int action;

	public ThreadUtil(Handler handler, String sendData, int action) {
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
			String jsonData = request(action);
			if (jsonData != null) {
				bundle.putString("data", jsonData);
				msg.setData(bundle);
				msg.what = 1;
			} else {
				Log.e("jdNull", "jsonData为空");
				msg.what = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("connException", "连接服务器失败,请检查网络");
			msg.what = -2;
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
	private String request(int action) throws Exception {
		switch (action) {
			case MONITOR_ALARM_INFO:
				return RemoteApiImpl.getMonitorAlarmInfo(sendData);
			default:
				return null;
		}
	}
}
