package com.hemebiotech.analytics.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hemebiotech.analytics.interfaces.ISymptomReportWriter;

import java.util.TreeMap;

/**
 * <b>Simple implementation of SymptomReportWriter for file datasource</b>
 * <p>
 * Usage :
 * </p>
 * <ol>
 * <li>Call constructor with filepath parameter.</li>
 * <li>Call writeSymptomSynthesis() function to write the data to file.</li>
 * </ol>
 *  
 * @see ISymptomReportWriter
 * 
 * @author jerome Lassus
 * @version 1.0
 */
public class SymptomReportWriterImplFile implements ISymptomReportWriter {

	/**
	 * Path for file writing the symptoms synthesis.
	 * This value is set with constructor.
	 * 
	 * @see SymptomSynthesisWriterImplFile#SymptomSynthesisWriterImplFile(String)
	 */
	private String filepath;

	/**
	 * Constructor for SymptomSynthesisWriterImplFile class.
	 * 
	 * @param filepath a full or partial path to file destination for symptom synthesis.
	 */
	public SymptomReportWriterImplFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public boolean writeReport(Map<String, Integer> symptomReport) {
		
		//Ordering the provided symptomSynthesis Map in a new TreeMap alphabeticaly ordered object:
		TreeMap<String, Integer> symptomSynthesisOrderedTreeMap = new TreeMap<>(symptomReport);
	
		//writing to file:
		if (filepath != null) {

			try (BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));)
			{	
				for ( Iterator<Entry<String, Integer>> iterator = symptomSynthesisOrderedTreeMap.entrySet().iterator(); iterator.hasNext();) 
				{
					Entry<String, Integer> couple = iterator.next();
					String symptom = couple.getKey();
					Integer count = couple.getValue();
					writer.write(symptom + ": " + count + "\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}

}


