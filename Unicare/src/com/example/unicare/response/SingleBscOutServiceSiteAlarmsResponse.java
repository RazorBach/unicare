package com.example.unicare.response;

import java.util.ArrayList;

public class SingleBscOutServiceSiteAlarmsResponse {
	ArrayList<AlarmsRecord> ARecord;

	public ArrayList<AlarmsRecord> getARecord() {
		return ARecord;
	}

	public void setARecord(ArrayList<AlarmsRecord> aRecord) {
		ARecord = aRecord;
	}

	public class AlarmsRecord {
		int id;
		int alarmNum;
		String neName;
		int siteId;
		int timeToLive;
		String cancelTime;

		public int getId() {
			return id;
		}

		public int getAlarmNum() {
			return alarmNum;
		}

		public String getNeName() {
			return neName;
		}

		public int getSiteId() {
			return siteId;
		}

		public int getTimeToLive() {
			return timeToLive;
		}

		public String getCancelTime() {
			return cancelTime;
		}
	}
}
