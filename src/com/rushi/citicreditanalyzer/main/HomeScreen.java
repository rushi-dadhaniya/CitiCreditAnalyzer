package com.rushi.citicreditanalyzer.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.io.UserPasswordScreen;

public class HomeScreen extends ActionBarActivity {

	private static String selectedFilePath;
	private static Button selectFileButton;
	private static final int filePickerRequestCode = 123;
	private static final String DOT = ".";
	private static final String PDF_EXTENSION = "pdf";
	private static final int ANIMATION_DURATION = 500;
	private static final String SELECT_PDF_FILE_MESSAGE = "Please select pdf file";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);

		final Animation animationTransalteForward = AnimationUtils.loadAnimation(this,
				R.anim.anim_translate_forward);

		selectFileButton = (Button) findViewById(R.id.selectFileButton);
		selectFileButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				animateButtonAndCallFilePicker(view);
			}

			public void animateButtonAndCallFilePicker(View view) {
				view.startAnimation(animationTransalteForward);
				Thread thread = new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(ANIMATION_DURATION);
						} catch (InterruptedException e) {
						}

						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								callFilePickerIntent();
							}

						});
					}
				};

				thread.start();

			}
		});
	}

	public void callFilePickerIntent() {

		Intent filePickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
		filePickerIntent.setType("file/*");
		startActivityForResult(filePickerIntent, getFilepickerRequestcode());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent resultantFilePickerIntent) {
		super.onActivityResult(requestCode, resultCode,
				resultantFilePickerIntent);

		if (requestCode == getFilepickerRequestcode()
				&& resultCode == RESULT_OK) {

			String filePath = resultantFilePickerIntent.getData().getPath();
			if (isPDFFile(filePath)) {
				
				Intent userPasswordIntent = new Intent(this,UserPasswordScreen.class);
				userPasswordIntent.putExtra("SelectedFilePath", filePath);
				startActivity(userPasswordIntent);
				
			} else {
				
				Toast.makeText(this, SELECT_PDF_FILE_MESSAGE, Toast.LENGTH_LONG)
						.show();
			}

		}
	}

	private boolean isPDFFile(String filePath) {

		if(filePath != null && !filePath.isEmpty()) {
			int dotIndex = filePath.lastIndexOf(DOT);
			String extension = filePath.substring(dotIndex + 1);
			return extension.equalsIgnoreCase(PDF_EXTENSION);
		}
		return false;

	}

	public static int getFilepickerRequestcode() {
		return filePickerRequestCode;
	}

	public static String getSelectedFilePath() {
		return HomeScreen.selectedFilePath;
	}

	public static void setSelectedFilePath(String sectedFilePath) {
		HomeScreen.selectedFilePath = sectedFilePath;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
