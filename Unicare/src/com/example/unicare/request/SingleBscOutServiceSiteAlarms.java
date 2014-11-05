package com.example.unicare.request;

public class SingleBscOutServiceSiteAlarms {
	BaseParameter BaseParameter;

	public SingleBscOutServiceSiteAlarms(int id) {
		this.BaseParameter = new BaseParameter(id);
	}

	class BaseParameter {
		int id;

		public BaseParameter(int id) {
			this.id = id;
		}
	}
}
