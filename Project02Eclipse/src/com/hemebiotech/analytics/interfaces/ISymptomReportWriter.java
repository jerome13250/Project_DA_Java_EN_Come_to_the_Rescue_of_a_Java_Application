package com.hemebiotech.analytics.interfaces;

import java.util.Map;

/**
 * <b>Interface to write symptom synthesis to a destination</b>
 * 
 */
public interface ISymptomReportWriter {
	
	/**
	 * Write the symptom Report report.
	 * 
	 * @param symptomReport a Map object with key=symptom and value=number of occurrences
	 * 
	 * @return a boolean for success (true) or failure (false) of writing
	 */
	boolean writeReport(Map<String,Integer> symptomReport );

}
