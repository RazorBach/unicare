package com.example.unicare.request;


public class MonitorAlarmInfo {
	BaseParameter BaseParameter;

	public MonitorAlarmInfo(int id) {
		this.BaseParameter = new BaseParameter(id);
	}
	
	class BaseParameter {
		int id;
		public BaseParameter(int id) {
			this.id = id;
		}
	}
}
