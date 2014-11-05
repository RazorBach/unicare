package com.example.unicare.request;

public class MonitorAlarms {
	BaseParameter BaseParameter;

	public MonitorAlarms(int id) {
		this.BaseParameter = new BaseParameter(id);
	}
	
	class BaseParameter {
		int id;
		public BaseParameter(int id) {
			this.id = id;
		}
	}
}