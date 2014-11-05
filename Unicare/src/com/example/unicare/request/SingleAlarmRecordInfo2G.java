package com.example.unicare.request;

public class SingleAlarmRecordInfo2G {

	BaseParameter BaseParameter;

	public SingleAlarmRecordInfo2G(int id) {
		this.BaseParameter = new BaseParameter(id);
	}

	class BaseParameter {
		int id;

		public BaseParameter(int id) {
			this.id = id;
		}
	}

}
