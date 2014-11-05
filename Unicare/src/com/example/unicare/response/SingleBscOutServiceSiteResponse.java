package com.example.unicare.response;

import java.util.ArrayList;

public class SingleBscOutServiceSiteResponse {
	ArrayList<SingleBscOutServiceSiteReport> MReport;

	public ArrayList<SingleBscOutServiceSiteReport> getMReport() {
		return MReport;
	}

	public void setMReport(ArrayList<SingleBscOutServiceSiteReport> mReport) {
		MReport = mReport;
	}

	public class SingleBscOutServiceSiteReport {
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
