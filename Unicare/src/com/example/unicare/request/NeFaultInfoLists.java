package com.example.unicare.request;

/**
 * 依靠state字段来区分
 */
public class NeFaultInfoLists {

	BaseParameter BaseParameter;

	public NeFaultInfoLists(int id, String state, String time) {
		this.BaseParameter = new BaseParameter(id, state, time);
	}
	
	class BaseParameter {
		int id;
		String state;
		String time;
		public BaseParameter(int id, String state, String time) {
			this.id = id;
			this.state = state;
			this.time = time;
		}
	}
	
}
