package com.example.unicare.request;

public class BscSiteAlarmLists {

	AlarmParameter AlarmParameter;

	public BscSiteAlarmLists(String siteId, String alarmNum, int count,
			int userId, int next) {
		this.AlarmParameter = new AlarmParameter(siteId, alarmNum, count, userId, next);
	}

	public void setNext(int next) {
		this.AlarmParameter.next = next;
	}
	
	public class AlarmParameter {
		int count; // 默认15
		int userId;
		int next; // 分页号
		String siteId;
		String alarmNum;
		
		public AlarmParameter(String siteId, String alarmNum, int count,
				int userId, int next) {
			this.count = count;
			this.alarmNum = alarmNum;
			this.siteId = siteId;
			this.next = next;
			this.userId = userId;
		}
	}

}
