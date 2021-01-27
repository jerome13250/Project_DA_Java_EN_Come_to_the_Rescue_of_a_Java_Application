package com.hemebiotech.analytics.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.interfaces.ISymptomReader;

/**
 * <b>Simple implementation of SymptomReader for file datasource</b>
 * <p>
 * Usage :
 * </p>
 * <ol>
 * <li>Call constructor with filepath parameter.</li>
 * <li>Call GetSymptoms() function to get the data from file.</li>
 * </ol>
 *  
 * @see ISymptomReader
 * 
 * @author jerome Lassus
 * @version 1.0
 */
public class SymptomReaderImplFromFile implements ISymptomReader {

	/**
	 * Path for file containing the symptoms.
	 * This value is set with constructor.
	 * 
	 * @see SymptomReaderImplFromFile#SymptomReaderImplFromFile(String)
	 */
	private String filepath;

	/**
	 * Constructor for SymptomReaderImplFromFile class.
	 * 
	 * @param filepath : a full or partial path to file with symptom strings in it, one per line
	 * 
	 * @see SymptomReaderImplFromFile#filepath
	 */
	public SymptomReaderImplFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath));)
			{	
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
