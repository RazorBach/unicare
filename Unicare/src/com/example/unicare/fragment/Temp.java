package com.example.unicare.fragment;

import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.unicare.R;
import com.example.unicare.common.Tool;
import com.example.unicare.request.MonitorAlarmInfo;
import com.example.unicare.response.MonitorAlarmInfoResponse;
import com.example.unicare.response.MonitorAlarmInfoResponse.AlarmInfo;
import com.example.unicare.threads.ThreadUtil;
import com.google.gson.Gson;

public class Temp extends Fragment implements OnClickListener {
	private Context context;
	private Gson gson = new Gson();
	private View view;
	
	// handler是主线程与子线程通讯的句柄
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			if (msg.what == 1) {
				// 成功获取服务器端数据
				try {
					receiveDataSuccuess(bundle.getString("data"));
				} catch (Exception e) {
					e.printStackTrace();
					Tool.ShowMessage(context, "抱歉，返回数据处理异常");
				}
			} else {
				Tool.ShowMessage(context, "网络不太好哦，请检查~");
			}

		}
	};

	public Temp() {

	}

	public Temp(Context context) {
		this.context = context;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		requestData();
	}

	/**
	 * 通过intent以及sharedpreference等初始化views的数据
	 */
	private void initData() {

	}

	/**
	 * 向服务器发送请求数据
	 */
	private void requestData() {
		int id = 839922;
		MonitorAlarmInfo monitorAlarmInfo = new MonitorAlarmInfo(id);
		String sendData = gson.toJson(monitorAlarmInfo);
		new Thread(new ThreadUtil(handler, sendData,
				ThreadUtil.MONITOR_ALARM_INFO)).start();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.alarm_detail, container, false);
		return view;
	}

	/**
	 * 成功接收到服务器端返回的xxxx后执行的操作
	 * 
	 * @throws JSONException
	 */
	protected void receiveDataSuccuess(String jsonData) throws JSONException {
		MonitorAlarmInfoResponse response = gson.fromJson(jsonData,
				MonitorAlarmInfoResponse.class);
		
		TextView alarmNum = (TextView) view.findViewById(R.id.monAlarmNum);
		TextView neName = (TextView) view.findViewById(R.id.monNeName);
		TextView siteId = (TextView) view.findViewById(R.id.monSiteId);
		TextView siteName = (TextView) view.findViewById(R.id.monSiteName);
		TextView alarmTime = (TextView) view.findViewById(R.id.monAlarmTime);
		TextView alarmCell = (TextView) view.findViewById(R.id.monAlarmCell);
		TextView alarmAnnex = (TextView) view.findViewById(R.id.monAlarmAnnex);
		TextView guide = (TextView) view.findViewById(R.id.monGuide);

		AlarmInfo alarmInfo = response.getARecord();

		alarmNum.setText(String.valueOf(alarmInfo.getAlarmNum()));
		neName.setText(alarmInfo.getNeName());
		siteId.setText(String.valueOf(alarmInfo.getSiteId()));
		siteName.setText(alarmInfo.getSiteName());
		alarmTime.setText(alarmInfo.getAlarmTime());
		alarmCell.setText(alarmInfo.getAlarmCell());
		alarmAnnex.setText(alarmInfo.getAlarmAnnex());
		guide.setText(alarmInfo.getGuide());
	}

	@Override
	public void onClick(View arg0) {

	}

}
