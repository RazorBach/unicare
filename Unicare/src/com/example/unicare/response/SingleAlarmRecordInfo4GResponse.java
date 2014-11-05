package com.example.unicare.response;

public class SingleAlarmRecordInfo4GResponse {
	AlarmInfo ARecord;

	public AlarmInfo getARecord() {
		return ARecord;
	}

	public class AlarmInfo {
		int id;
		int alarmNum;
		int siteId;
		String siteName;
		String alarmTime;
		String cancelTime;
		String alarmAnnex;
		String guide;

		public int getId() {
			return id;
		}

		public int getAlarmNum() {
			return alarmNum;
		}

		public int getSiteId() {
			return siteId;
		}

		public String getSiteName() {
			return siteName;
		}

		public String getAlarmTime() {
			return alarmTime;
		}

		public String getCancelTime() {
			return cancelTime;
		}

		public String getAlarmAnnex() {
			return alarmAnnex;
		}

		public String getGuide() {
			return guide;
		}

	}
}
