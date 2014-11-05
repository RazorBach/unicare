package com.example.unicare.request;

public class SingleBscOutServiceSite {
	BaseParameter BaseParameter;

	public SingleBscOutServiceSite(String time, int userId) {
		this.BaseParameter = new BaseParameter(time, userId);
	}

	public SingleBscOutServiceSite(int userId) {
		this.BaseParameter = new BaseParameter(userId);
	}

	class BaseParameter {
		String time;
		int userId;

		public BaseParameter(int userId) {
			this.userId = userId;
		}

		public BaseParameter(String time, int userId) {
			super();
			this.time = time;
			this.userId = userId;
		}
	}
}
