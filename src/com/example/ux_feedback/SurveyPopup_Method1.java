package com.example.ux_feedback;

import java.util.Collection;
import java.util.LinkedList;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SurveyPopup_Method1 extends Activity {	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey_popup__method1);
		
		combinedResults = new LinkedList<Integer>();
		
		SharedPreferences preferences = getSharedPreferences("surveyPrefs", 0);
		Boolean SurveyCompleted = preferences.getBoolean("SurveyCompleted", false);
		
		if(SurveyCompleted){
			ShowEndSurveyUI();
		}
		else{
			ShowStartSurveyUI();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey_popup__method1, menu);
		return true;
	}
	
	LinkedList<Integer> combinedResults;
	
	int PAGE_1_ACTIVITY = 1;
	int PAGE_2_ACTIVITY = 2;
	int PAGE_3_ACTIVITY = 3;
	
	int RESULT_OK = 1;
	int RESULT_CANCELLED = 2;
	
	Boolean P1_Complete;
	Boolean P2_Complete;
	Boolean P3_Complete;
	
	private void ShowEndSurveyUI(){
		LinearLayout BeginLinearLayout = (LinearLayout)findViewById(R.id.BeginSurveyUI);
		BeginLinearLayout.setVisibility(View.GONE);
		
		LinearLayout EndLinearLayout = (LinearLayout)findViewById(R.id.EndSurveyUI);
		EndLinearLayout.setVisibility(View.VISIBLE);		
	}
	
	public void ShowStartSurveyUI(){
		LinearLayout BeginLinearLayout = (LinearLayout)findViewById(R.id.BeginSurveyUI);
		BeginLinearLayout.setVisibility(View.VISIBLE);
		
		LinearLayout EndLinearLayout = (LinearLayout)findViewById(R.id.EndSurveyUI);
		EndLinearLayout.setVisibility(View.GONE);		
	}
	
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
	
	public void End(View v){
		this.finish();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == PAGE_1_ACTIVITY){
			if(resultCode == RESULT_OK){
				P1_Complete = true;
				Bundle bundle =	data.getExtras();
				combinedResults.addAll((Collection<? extends Integer>) bundle.get("result"));
				//TextView view = (TextView)findViewById(R.id.TextView_m1_p1_status);
				//view.setText("Fuldført.");
				startP2(null);
			}
			else {
				
			}			
		}
		else if (requestCode == PAGE_2_ACTIVITY){
			if(resultCode == RESULT_OK){
				P2_Complete = true;
				Bundle bundle =	data.getExtras();
				combinedResults.addAll((Collection<? extends Integer>) bundle.get("result"));
				//TextView view = (TextView)findViewById(R.id.TextView_m1_p2_status);
				//view.setText("Fuldført.");
				startP3(null);
			}
			else {
				
			}			
		}
		else if (requestCode == PAGE_3_ACTIVITY){
			if(resultCode == RESULT_OK){
				P3_Complete = true;
				Bundle bundle =	data.getExtras();
				combinedResults.addAll((Collection<? extends Integer>) bundle.get("result"));
				//TextView view = (TextView)findViewById(R.id.TextView_m1_p3_status);
				//view.setText("Fuldført.");
				if(P1_Complete == true && P2_Complete == true && P3_Complete == true){
					
					ShowEndSurveyUI();
					//and add data to the database.
					/*
					SharedPreferences preferences = getSharedPreferences("surveyPrefs", 0);
					SharedPreferences.Editor editor = preferences.edit();
					editor.putBoolean("SurveyCompleted", true);
					editor.commit();
					*/
				}
			}
			else {
				
			}
		}
		else {
			//wtf?!
		}
	}

}
