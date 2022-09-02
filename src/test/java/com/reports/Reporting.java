
package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJvmReport(String jsonFile) {

		File file = new File(System.getProperty("user.dir") + "\\target\\JvmReport");

		Configuration configuration = new Configuration(file, "OMRBranchAdactinAutomation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "105");
		configuration.addClassifications("OS", "Win10");
		configuration.addClassifications("Sprint", "21");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		builder.generateReports();

	}
}
