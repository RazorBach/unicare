package com.example.unicare.response;

import java.util.ArrayList;

public class LteOutServiceSiteResponse {
	ArrayList<LteOutServiceSiteReport> MReport;

	public ArrayList<LteOutServiceSiteReport> getMReport() {
		return MReport;
	}

	public void setMReport(ArrayList<LteOutServiceSiteReport> mReport) {
		MReport = mReport;
	}

	public class LteOutServiceSiteReport {
		int id;
		String description;

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}
	}
}
