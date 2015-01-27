package com.rushi.citicreditanalyzer.fileprocessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextFileParser {

	public Map<String, Integer> createTextFileMap(String filePath) {
		
		Map<String, Integer> fileLineNumberMap = new LinkedHashMap<String, Integer>();
		
		BufferedReader fileReader = getFileReader(filePath);
		String currentLine;
		int lineNumber = 1;
		try {
			
			while((currentLine = fileReader.readLine()) != null) {
				
				if(!currentLine.isEmpty()) {
					fileLineNumberMap.put(currentLine, lineNumber);
				}
				lineNumber++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getLineFromFile(BufferedReader fileReader) {
		
		try {
			return fileReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private BufferedReader getFileReader(String filePath) {
		
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileReader;
	}
}
