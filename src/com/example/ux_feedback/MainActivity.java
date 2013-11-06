package com.example.ux_feedback;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences appPreferences = getSharedPreferences("appPrefs", 0);
		SharedPreferences.Editor editor = appPreferences.edit();
		//set to true for participants on method 2
		editor.putBoolean("ESM_Enabled", false);
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void btn1_Clicked (View v){
		Intent intent = new Intent(this, SurveyPopup_Method1.class);
		startActivity(intent);
	}
	
	public void btn2_Clicked (View v){
		Intent intent = new Intent(this, SurveyPopup_Method2.class);
		startActivity(intent);
	}
	
	// make methods that display survey methods depending on user settings
	// get user id etc. from database.

}
