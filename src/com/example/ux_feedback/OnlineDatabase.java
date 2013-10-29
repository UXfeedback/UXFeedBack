package com.example.ux_feedback;

import org.json.JSONException;
import org.json.JSONObject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

public class OnlineDatabase extends AsyncTask {

	JSONParser jsonParser = new JSONParser();
	LocalDatabase ldb = new LocalDatabase(null);
	//url input value
	String url_add = "";
	
	
	//Table_name skal v�re navnet p� den table(alts� navnet p� metoden) dataen skal inds�ttes i
	//MANGLER: Hvilket data f�r denne funktion???
	
	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		
		String table_name = null;
		String CHECK = null;
		int ID_DATA = 0;
		int ID = 0;
		
		
		SQLiteDatabase rdb = ldb.getReadableDatabase();
		//Query: Finder den sidste fra denne bruger
		String query = "SELECT * FROM " + table_name 
				+ "WHERE " + ID_DATA + " = " 
				+ ("SELECT MAX(ID_DATA) FROM " + table_name);
		
		Cursor c = rdb.rawQuery(query, null);
		c.moveToFirst();
		
		//MANGLER: Dataet funktionen f�r
		ESM_Datatype Data = ldb.DataType(table_name);
		
		//cursor object to custom object

		int column = c.getColumnIndex(CHECK);
		int check = c.getInt(column); 
						
		if(check == 1) {
			//Local_Add(table_name, Data);
		}
		else { 
			
			//Cursor object to ESM_Datatype
			ESM_Datatype Data_lost = ldb.DataType(table_name);
			
			
			//Online_Add(table_name, Data_lost);
			
			
			ldb.InsertDatabase(table_name, ID); //Mangler de data function f�r fra broadcast reciever
		}
		
		return null;
	}

}
