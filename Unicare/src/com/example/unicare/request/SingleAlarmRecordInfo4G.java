package com.example.unicare.request;

public class SingleAlarmRecordInfo4G {
	BaseParameter BaseParameter;

	public SingleAlarmRecordInfo4G(int id, String vendor) {
		this.BaseParameter = new BaseParameter(id, vendor);
	}

	class BaseParameter {
		int id;
		String vendor;
		
		public BaseParameter(int id, String vendor) {
			this.id = id;
			this.vendor = vendor;
		}
	}
}
