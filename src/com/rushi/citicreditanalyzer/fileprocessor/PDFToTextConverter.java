package com.rushi.citicreditanalyzer.fileprocessor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.citicreditanalyzer.R;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

public class PDFToTextConverter extends ActionBarActivity{

	private String userSelectedFilePath;
	private String userPassword;
	private String internalMemoryPath;
	private String textFilePath;
	private static final String APP_NAME = "CitiCreditAnalyzer";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pdfconverter);
		
		TextView convertingTextView = (TextView) findViewById(R.id.convertingMessageTextVew);
		setInternalMemoryPath(Environment.getExternalStorageDirectory().getAbsolutePath());
		
		Intent currentIntent = getIntent();
		if(currentIntent != null) {
			
			setUserSelectedFilePath(currentIntent.getStringExtra("selectedFilePath"));
			setUserPassword(currentIntent.getStringExtra("userPassword"));
			
		}
			
		createUrlForTextFile();
		
		Log.d("user selected file", getUserSelectedFilePath());
		Log.d("user password", getUserPassword());
		Log.d("internal",getInternalMemoryPath());
		Log.d("text file path",getTextFilePath());
		
		
		try {
			createTextFileFromPDF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		convertingTextView.setText("Done");
	}

	private void createUrlForTextFile() {

		File myAppDirectory = new File(getInternalMemoryPath() + "/" + APP_NAME + "/");
		if(!myAppDirectory.exists())
			myAppDirectory.mkdirs();
		setTextFilePath(myAppDirectory.getAbsolutePath() + "/" + "tempfile.txt");
	}

	private void createTextFileFromPDF() throws IOException {
		
		PdfReader reader = new PdfReader(getUserSelectedFilePath(),getUserPassword().getBytes());
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        PrintWriter out = new PrintWriter(new FileOutputStream(getTextFilePath()));
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            out.println(strategy.getResultantText());
        }
        
        out.flush();
        out.close();
        reader.close();
		
		
	}

	public String getUserSelectedFilePath() {
		return userSelectedFilePath;
	}

	public void setUserSelectedFilePath(String userSelectedFilePath) {
		this.userSelectedFilePath = userSelectedFilePath;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getInternalMemoryPath() {
		return internalMemoryPath;
	}

	public void setInternalMemoryPath(String internalMemoryPath) {
		this.internalMemoryPath = internalMemoryPath;
	}

	public String getTextFilePath() {
		return textFilePath;
	}

	public void setTextFilePath(String textFilePath) {
		this.textFilePath = textFilePath;
	}

}
