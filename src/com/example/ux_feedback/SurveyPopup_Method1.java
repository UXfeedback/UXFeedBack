package com.example.ux_feedback;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SurveyPopup_Method1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey_popup__method1);
		
		//nothing here yet.
		SeekBar sb1 = (SeekBar)findViewById(R.id.m1_q1_seekBar);
		sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
				TextView view = (TextView)findViewById(R.id.m1_q1_field);
				UpdateTextView(view, seekBar.getProgress());			
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey_popup__method1, menu);
		return true;
	}
	
	private void UpdateTextView(TextView v, int value){		
		String tmp = " "+value;
		v.setText(tmp);		
	}

}
