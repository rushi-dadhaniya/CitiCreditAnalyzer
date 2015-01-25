package com.rushi.citicreditanalyzer.fileprocessor;

public class FileUtil {

	private static final String DOT = ".";
	
	public boolean isPDFFile(String filePath) {
		
		String fileExtension = getExtension(filePath);
		if(fileExtension != null) {
			return fileExtension.equalsIgnoreCase("pdf");
		}
		return false;
		
	}

	private String getExtension(String filePath) {

		if(filePath != null && !filePath.isEmpty()) {
			int dotIndex = filePath.lastIndexOf(DOT);
			if(dotIndex >= 0)
				return filePath.substring(dotIndex + 1);
		}
		
		return null;
	}
	
}
