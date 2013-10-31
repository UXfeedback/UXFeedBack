package com.example.ux_feedback;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
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
		/*
		sb1 = (SeekBar)findViewById(R.id.m1_q1_seekBar);
		sb2 = (SeekBar)findViewById(R.id.m1_q2_seekBar);
		
		sb1.setOnSeekBarChangeListener(OnSeekBarProgress);
		sb2.setOnSeekBarChangeListener(OnSeekBarProgress);
		
		
		tv1 = (TextView)findViewById(R.id.m1_q1_field);
		tv2 = (TextView)findViewById(R.id.m1_q2_field);
		*/
	}
	/*
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
	*/


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey_popup__method1, menu);
		return true;
	}
	/*
	private void UpdateTextView(TextView v, int value){		
		String tmp = " "+(value +1);
		v.setText(tmp);		
	}
	*/
	
	int PAGE_1_ACTIVITY = 1;
	int PAGE_2_ACTIVITY = 2;
	int PAGE_3_ACTIVITY = 3;
	
	int RESULT_OK = 1;
	int RESULT_CANCELLED = 2;
	
	Boolean P1_Complete;
	Boolean P2_Complete;
	Boolean P3_Complete;
	
	public void startP1(View v){
		Intent intent = new Intent(this, Survey_method1_part1.class);	
		startActivityForResult(intent,PAGE_1_ACTIVITY);
	}
	
	public void startP2(View v){
		Intent intent = new Intent(this, Survey_method1_part2.class);	
		startActivityForResult(intent,PAGE_2_ACTIVITY);
	}
	
	public void startP3(View v){
		Intent intent = new Intent(this, Survey_method1_part3.class);	
		startActivityForResult(intent,PAGE_3_ACTIVITY);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == PAGE_1_ACTIVITY){
			if(resultCode == RESULT_OK){
				TextView view = (TextView)findViewById(R.id.TextView_m1_p1_status);
				view.setText("Fuldført.");
				startP2(null);
			}
			else {
				
			}			
		}
		else if (requestCode == PAGE_2_ACTIVITY){
			if(resultCode == RESULT_OK){
				TextView view = (TextView)findViewById(R.id.TextView_m1_p2_status);
				view.setText("Fuldført.");
				startP3(null);
			}
			else {
				
			}			
		}
		else if (requestCode == PAGE_3_ACTIVITY){
			if(resultCode == RESULT_OK){
				TextView view = (TextView)findViewById(R.id.TextView_m1_p3_status);
				view.setText("Fuldført.");			
			}
			else {
				
			}
		}
		else {
			//wtf?!
		}
	}

}
