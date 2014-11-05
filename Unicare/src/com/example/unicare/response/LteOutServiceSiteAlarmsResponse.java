package com.example.unicare.response;

import java.util.ArrayList;

public class LteOutServiceSiteAlarmsResponse {
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
		int siteId;
		int timeToLive;

		public int getId() {
			return id;
		}

		public int getAlarmNum() {
			return alarmNum;
		}

		public int getSiteId() {
			return siteId;
		}

		public int getTimeToLive() {
			return timeToLive;
		}
	}
}
