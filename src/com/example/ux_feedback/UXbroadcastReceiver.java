package com.example.ux_feedback;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class UXbroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		
		//extract extra info from intent and decide on what to do. 
		//Start survey intent or add some data to the database
		
		boolean condition = true;
		
		if(condition)		
		{
			//Intent intent = new Intent(arg0, SurveyPopup.class);
			//intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			//arg0.startActivity(intent);
			
		}
		else
		{
			//Log some other data
		}
	}

}
