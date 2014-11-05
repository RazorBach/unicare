package com.example.unicare.request;

public class MonAnalysisList {
	BaseParameter BaseParameter;

	public MonAnalysisList(String startTime, String endTime, int userId) {
		this.BaseParameter = new BaseParameter(startTime, endTime, userId);
	}
	
	public MonAnalysisList(int userId) {
		this.BaseParameter = new BaseParameter(userId);
	}
	
	class BaseParameter {
		String startTime;
		String endTime;
		int userId;
		
		public BaseParameter(int userId) {
			this.userId = userId;
		}

		public BaseParameter(String startTime, String endTime, int userId) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
			this.userId = userId;
		}
	}
}
