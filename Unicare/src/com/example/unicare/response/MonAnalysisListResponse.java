package com.example.unicare.response;

import java.util.ArrayList;

public class MonAnalysisListResponse {
	ArrayList<MonAnalysisDescription> MReport;
	
	public ArrayList<MonAnalysisDescription> getMReport() {
		return MReport;
	}

	public void setMReport(ArrayList<MonAnalysisDescription> mReport) {
		MReport = mReport;
	}
	
	public class MonAnalysisDescription {
		int id;
		String description;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public MonAnalysisDescription(int id, String description) {
			super();
			this.id = id;
			this.description = description;
		}
	}
}
