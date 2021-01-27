package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.Map;

/**
 * 
 * Interface for symptoms analyzer service.
 * 
 * @author jerome Lassus
 *
 */
public interface ISymptomAnalyzer {
	
	
	/**
	 * Create the symptom Synthesis report from the symptoms list.
	 * 
	 * @param symptomsList the list of symptoms to analyze.
	 * 
	 * @return Map object with key=symptom and value=number of occurrences
	 */
	public Map<String,Integer> analyze(List<String> symptomsList);
	

}