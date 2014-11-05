package com.example.unicare.request;

public class LteOutServiceSiteAlarms {
	BaseParameter BaseParameter;

	public LteOutServiceSiteAlarms(int id) {
		this.BaseParameter = new BaseParameter(id);
	}

	class BaseParameter {
		int id;

		public BaseParameter(int id) {
			this.id = id;
		}
	}
}
