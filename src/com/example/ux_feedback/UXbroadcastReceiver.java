package com.example.ux_feedback;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;


public class UXbroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub		
		
		//extract extra info from intent and decide on what to do. 
		//Start survey intent or add some data to the database
		
		SharedPreferences appPreferences = arg0.getSharedPreferences("appPrefs", 0);
		boolean ESM_enabled = appPreferences.getBoolean("ESM_Enabled", false);		
		
		
		if(ESM_enabled)		
		{
			//do an additional check to see if 
			if(true){
				Intent intent = new Intent(arg0, SurveyPopup_Method2.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				arg0.startActivity(intent);	
			}	
		}
		else
		{
			//Log some other data
		}
		
		
	}

}
