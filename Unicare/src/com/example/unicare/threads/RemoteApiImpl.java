package com.example.unicare.threads;

import android.util.Log;

import com.example.unicare.common.HttpUtils;
import com.example.unicare.common.PropertiesUtils;

public class RemoteApiImpl {

	/**
	 * 告警详细信息
	 */
	public static String getMonitorAlarmInfo(String sendData)
			throws Exception {
		String url = PropertiesUtils.getApi("monitor_alarm_info");
		Log.d("JSON", sendData.toString());
		String jsonData = HttpUtils.sendJSONPost(url, sendData);
		return jsonData;
	}
}