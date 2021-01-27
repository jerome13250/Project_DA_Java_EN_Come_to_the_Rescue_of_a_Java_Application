package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.impl.SymptomAnalyzerImplHashMap;
import com.hemebiotech.analytics.impl.SymptomReaderImplFromFile;
import com.hemebiotech.analytics.impl.SymptomReportWriterImplFile;
import com.hemebiotech.analytics.interfaces.ISymptomAnalyzer;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomReportWriter;

public class AnalyticsCounter {
	
		
	public static void main(String[] args) {

		String inputFile = "symptoms.txt";
		String outputFile = "results.out";
		
		//reader:
		ISymptomReader symptomReader = new SymptomReaderImplFromFile(inputFile);
		List<String> symptomsList = symptomReader.getSymptoms();
		System.out.println("symptomsList = " + symptomsList);
		
		//analyzer:
		ISymptomAnalyzer symptomAnalyzer = new SymptomAnalyzerImplHashMap();
		Map<String, Integer> symptomsReport = symptomAnalyzer.analyze(symptomsList);
		System.out.println("symptomsReport = " + symptomsReport);

		//writer:
		ISymptomReportWriter symptomReportWriter = new SymptomReportWriterImplFile(outputFile);
		boolean writeHasSucceeded = symptomReportWriter.writeReport(symptomsReport);
		System.out.println("Writing the symptoms report has succeeded : "+ writeHasSucceeded);

	}
}
