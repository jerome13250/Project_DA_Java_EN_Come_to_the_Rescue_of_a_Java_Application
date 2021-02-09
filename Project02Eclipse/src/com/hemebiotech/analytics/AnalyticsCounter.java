package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.impl.SymptomAnalyzerImplTreeMap;
import com.hemebiotech.analytics.impl.SymptomReaderImplFromFile;
import com.hemebiotech.analytics.impl.SymptomReportWriterImplFile;

public class AnalyticsCounter {
	
		
	public static void main(String[] args) {

		String inputFile = "symptoms.txt";
		String outputFile = "results.out";
		
		//reader:
		SymptomReaderImplFromFile symptomReaderImplFromFile = new SymptomReaderImplFromFile();
		List<String> symptomsList = symptomReaderImplFromFile.getSymptoms(inputFile);
		System.out.println("symptomsList = " + symptomsList);
		
		//analyzer:
		SymptomAnalyzerImplTreeMap symptomAnalyzerImplHashMap = new SymptomAnalyzerImplTreeMap();
		Map<String, Integer> symptomsReport = symptomAnalyzerImplHashMap.analyze(symptomsList);
		System.out.println("symptomsReport = " + symptomsReport);

		//writer:
		SymptomReportWriterImplFile symptomReportWriterImplFile = new SymptomReportWriterImplFile();
		boolean writeHasSucceeded = symptomReportWriterImplFile.writeReport(symptomsReport,outputFile);
		System.out.println("Writing the symptoms report has succeeded : "+ writeHasSucceeded);

	}
}
