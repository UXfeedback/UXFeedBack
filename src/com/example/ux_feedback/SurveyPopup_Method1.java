package com.example.ux_feedback;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SurveyPopup_Method1 extends Activity {
	
	SeekBar sb1;
	SeekBar sb2;
	SeekBar sb3;
	SeekBar sb4;
	SeekBar sb5;
	SeekBar sb6;
	SeekBar sb7;
	
	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
	TextView tv5;
	TextView tv6;
	TextView tv7;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey_popup__method1);
		
		sb1 = (SeekBar)findViewById(R.id.m1_q1_seekBar);
		sb2 = (SeekBar)findViewById(R.id.m1_q2_seekBar);
		
		sb1.setOnSeekBarChangeListener(OnSeekBarProgress);
		sb2.setOnSeekBarChangeListener(OnSeekBarProgress);
		
		
		tv1 = (TextView)findViewById(R.id.m1_q1_field);
		tv2 = (TextView)findViewById(R.id.m1_q2_field);
	}
	
	OnSeekBarChangeListener OnSeekBarProgress =
	        new OnSeekBarChangeListener() {

				@Override
				public void onProgressChanged(SeekBar s, int value,
						boolean touch) {
					
					if(s.getId() == R.id.m1_q1_seekBar)
					{
						UpdateTextView(tv1, value);
					}
					else if (s.getId() == R.id.m1_q2_seekBar)
					{
						UpdateTextView(tv2, value);
					}
				}

				@Override
				public void onStartTrackingTouch(SeekBar arg0) {
				}

				@Override
				public void onStopTrackingTouch(SeekBar arg0) {
				}
		
	};
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey_popup__method1, menu);
		return true;
	}
	
	private void UpdateTextView(TextView v, int value){		
		String tmp = " "+(value +1);
		v.setText(tmp);		
	}

}
