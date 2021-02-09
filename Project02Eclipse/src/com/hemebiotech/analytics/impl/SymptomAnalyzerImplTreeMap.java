package com.hemebiotech.analytics.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.interfaces.ISymptomAnalyzer;

/**
 * <b>Implementation of SymptomAnalyzer using TreeMap.</b>
 * 
 * <p>
 * Usage :
 * </p>
 * <ol>
 * <li>Call constructor.</li>
 * <li>Call analyze() function to get the synthesis report.</li>
 * </ol>
 *   
 * @see ISymptomAnalyzer
 * 
 * @author jerome Lassus
 * @version 1.0
 */
public class SymptomAnalyzerImplTreeMap implements ISymptomAnalyzer {

	@Override
	public Map<String, Integer> analyze(List<String> symptomsList) {

		Map<String, Integer> symptomReport = new TreeMap<>();

		symptomsList.forEach( symptom -> {
			if (!symptomReport.containsKey(symptom)) //symptom not present in synthesisReport
			{
				symptomReport.put(symptom, 1); //add symptom to synthesisReport with 1 as occurence count
			}
			else //symptom already present in synthesisReport
			{
				int occurenceCount = symptomReport.get(symptom)+1;
				symptomReport.put(symptom, occurenceCount);
			}

		});

		return symptomReport;

	}

}





