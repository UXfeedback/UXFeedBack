package com.example.ux_feedback;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SurveyPopup_Method2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey_popup__method2);
		
		//nothing here yet
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey_popup__method2, menu);
		return true;
	}

}
