package com.rushi.citicreditanalyzer.io;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.main.HomeScreen;
import com.rushi.citicreditanalyzer.screen.FeatureListScreen;

public class UserPasswordScreen extends ActionBarActivity{

	private static EditText userPasswordEditText;
	private static String filePath;
	private static final String ENTER_PASSWORD_MESSAGE = "Please enter password";
	private static final String USER_SELECTED_FILE = "You have selected ";
	private static Animation animationTranslate;
	private static final int ANIMATION_DURATION = 500;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userpassword_screen);
		
		Intent userPasswordIntent = getIntent();
		setFilePath(userPasswordIntent.getStringExtra("selectedFilePath"));
		
		final Animation animationTransalteForward = AnimationUtils.loadAnimation(this,
				R.anim.anim_translate_forward);
		final Animation animationTransalteBackward = AnimationUtils.loadAnimation(this,
				R.anim.anim_translate_backward);
		
		final TextView selectedFileTextView = (TextView) findViewById(R.id.selectedFileTextView);
		selectedFileTextView.setText(getUserSelectedFile() + getFilePath());
		selectedFileTextView.setGravity(Gravity.CENTER_HORIZONTAL);
		userPasswordEditText = (EditText) findViewById(R.id.passwordEditText);
		final Button passwordSubmitButton = (Button) findViewById(R.id.submitPasswordButton);
		final Button backButton = (Button) findViewById(R.id.backButton);
		
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {

				setAnimationTranslate(animationTransalteBackward);
				animateBackwardAndInvokeIntent(view);
				
			}
			
		});
		
		
		passwordSubmitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				setAnimationTranslate(animationTransalteForward);
				animateForwardAndInvokeIntent(view);
				
			}

		});
	}
	
	private void animateForwardAndInvokeIntent(View view) {

		view.startAnimation(getAnimationTranslate());
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
						submitUserPassword();
					}

				});
			}
		};

		thread.start();
	}
	
	private void animateBackwardAndInvokeIntent(View view) {

		view.startAnimation(getAnimationTranslate());
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
						invokeHomeScreenActivity();
					}

				});
			}
		};

		thread.start();
	}
	
	private void invokeHomeScreenActivity() {
		
		Intent homeScreenIntent = new Intent(this,HomeScreen.class);
		startActivity(homeScreenIntent);
		
	}
	
	private void submitUserPassword() {

		String userPassword = getUserpasswordedittext().getText().toString();
		if(userPassword != null && !userPassword.isEmpty()) {
			
			processRequest(userPassword);
		}
		else {
			Toast.makeText(this, ENTER_PASSWORD_MESSAGE, Toast.LENGTH_SHORT).show();
		}
		
	}

	private void processRequest(String userPassword) {

		Intent FeatureListIntent = new Intent(this, FeatureListScreen.class);
		FeatureListIntent.putExtra("selectedFilePath", getFilePath());
		FeatureListIntent.putExtra("userPassword", userPassword);
		startActivity(FeatureListIntent);
	}

	public static EditText getUserpasswordedittext() {
		return userPasswordEditText;
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		UserPasswordScreen.filePath = filePath;
	}

	public static String getUserSelectedFile() {
		return USER_SELECTED_FILE;
	}

	public static Animation getAnimationTranslate() {
		return animationTranslate;
	}

	public static void setAnimationTranslate(Animation animationTranslate) {
		UserPasswordScreen.animationTranslate = animationTranslate;
	}

}
