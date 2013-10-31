package com.example.ux_feedback;

import java.util.LinkedList;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class Survey_method1_part3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey_method1_part3);
		
		InitializeRadioGroupList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey_method1_part3, menu);
		return true;
	}
	
	LinkedList<RadioGroup> groups = new LinkedList<RadioGroup>();
	LinkedList<Integer> results = new LinkedList<Integer>();
	
	
	int RESULT_OK = 1;
	int RESULT_CANCELLED = 2;
	
	private void InitializeRadioGroupList(){
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q20));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q21));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q22));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q23));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q24));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q25));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q26));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q27));
		groups.add((RadioGroup)findViewById(R.id.RadioGroup_m1_q28));		
	}
	
	private RadioGroup uncompletedGroup;
	
	private Boolean GetData(){
		boolean isComplete = true;
		
		for(RadioGroup rg: groups){
			int index = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));			
			results.add(index +1);
			
			if(index == -1){
				isComplete = false;
				
				if(uncompletedGroup == null){
					uncompletedGroup = rg;
				}
				
				
			}
		}
		return isComplete;
	}
	
	private final void focusOnView(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {            	
            	ScrollView scrollview = (ScrollView)findViewById(R.id.ScrollView_m1_p3);
                scrollview.scrollTo(0, uncompletedGroup.getTop() - 50);
                
                LinearLayout parent = (LinearLayout)uncompletedGroup.getParent();
                parent.setBackgroundColor(Color.RED);
                
            }
        });
    }
	
	public void btn_next_clicked(View v){
		
		Boolean QuestionnaireCompleted = GetData();		
		
		if(QuestionnaireCompleted){
			Intent intent = new Intent();
			intent.putExtra("result", results);
			setResult(RESULT_OK,intent);
			finish();
		}
		else {
			
			focusOnView();
			
			/*
			Intent intent = new Intent();
			setResult(RESULT_CANCELED, intent);
			finish();
			*/
		}		
	}

}
