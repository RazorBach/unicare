package com.example.unicare.response;

public class SingleAlarmRecordInfo2GResponse {
	AlarmInfo ARecord;

	public AlarmInfo getARecord() {
		return ARecord;
	}

	public class AlarmInfo {
		int id;
		int alarmNum;
		String neName;
		int siteId;
		String siteName;
		String alarmTime;
		String cancelTime;
		String alarmCell;
		String alarmAnnex;
		String guide;

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

		public String getSiteName() {
			return siteName;
		}

		public String getAlarmTime() {
			return alarmTime;
		}

		public String getCancelTime() {
			return cancelTime;
		}

		public String getAlarmCell() {
			return alarmCell;
		}

		public String getAlarmAnnex() {
			return alarmAnnex;
		}

		public String getGuide() {
			return guide;
		}

	}
}
