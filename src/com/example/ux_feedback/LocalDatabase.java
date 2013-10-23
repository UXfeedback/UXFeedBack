package com.example.ux_feedback;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class LocalDatabase extends SQLiteOpenHelper {
	
		//TABLE 1
		public static String TABLE_NAME1 = "Methode_1";
		public static String ID_DATA = "ID_DATA";
		public static String ID_USER = "ID_USER";
		public static String DATA  = "DATA";
		public static String POSITION = "POSITION";
		public static String CHECK = "CHECK";
		public static String DATE = "DATE";
		
		//TABLE 2
		public static String TABLE_NAME2 = "Methode_2";
		public static String DATA2 = "DATA2";
		public static String CHECK2 = "CHECK2";
		public static String ID_USER2 = "ID_USER2";

		
		//TABLE 3
		public static String TABLE_NAME3 = "USE_DATA";
		public static String AKTIVITY = "AKTIVITY";
		public static String CHECK3 = "CHECK3";
		public static String ID_USER3 = "ID_USER3";

		
		private static final String DATABASE_NAME = "localdatabase";
			private static final int DATABASE_VERSION = 1;
				LocalDatabase (Context context) {
				super(context, DATABASE_NAME, null, DATABASE_VERSION);
			}
			
			@Override
			public void onCreate(SQLiteDatabase db) {
			//we do something
				 String Table1 = "CREATE TABLE " + TABLE_NAME1
						 + " (" + ID_DATA + "INTEGER PRIMARY AUTOINCREMENT,"
						 + ID_USER + " INTEGER,"
						 + DATA + " TEXT,"
						 + POSITION + " TEXT,"
						 + DATE + " DATETIME, "
						 + CHECK + " INT)";
				 
				 db.execSQL(Table1);
				 
				 String Table2 = "CREATE TABLE " + TABLE_NAME2
						 + " (" + ID_DATA + "INTEGER PRIMARY AUTOINCREMENT,"
						 + ID_USER2 + " INTEGER,"
						 + DATA2 + " TEXT,"
						 + CHECK2 + " INT)";
				db.execSQL(Table2);
				
				String Table3 = "CREATE TABLE " + TABLE_NAME3
						+ " (" + ID_DATA + "INTEGER PRIMARY AUTOINCREMENT,"
						+ ID_USER3 + " INTEGER,"
						+ AKTIVITY + "TEXT, "
						+ DATE + " DATETIME, "
						+ CHECK3 + " INT)";
				db.execSQL(Table3);
			}
			
			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//we do something
			}
			//Table_name skal være navnet på den table(altså navnet på metoden) dataen skal indsættes i
			//MANGLER: Hvilket data får denne funktion???
			public void InsertDatabase(String table_name, int ID) {
				
				SQLiteDatabase rdb = getReadableDatabase();
				//Query: Finder den sidste fra denne bruger
				String query = "SELECT * FROM " + table_name 
						+ "WHERE " + ID_DATA + " = " 
						+ ("SELECT MAX(ID_DATA) FROM " + table_name);
				
				Cursor c = rdb.rawQuery(query, null);
				c.moveToFirst();
				
				//MANGLER: Dataet funktionen får
				ESM_Datatype Data = DataType(table_name);
				
				//cursor object to custom object

				int column = c.getColumnIndex(CHECK);
				int check = c.getInt(column); 
								
				if(check == 1) {
					//Local_Add(table_name, Data);
				}
				else { 
					
					//Cursor object to ESM_Datatype
					ESM_Datatype Data_lost = DataType(table_name);
					
					
					//Online_Add(table_name, Data_lost);
					
					
					InsertDatabase(table_name, ID); //Mangler de data function får fra broadcast reciever
				}
				
			}
			//MANGLER: De variabler der skal indsættes!!
			public ESM_Datatype DataType(String methode) {
				
				// MANGLER: if sætning skal være noget andet!!
				if(methode == "type") {
					ESM_Datatype Data = new ESM_Datatype(0, null, null);
					return Data;
				}
				else {
					ESM_Datatype Data = new ESM_Datatype(0, null);
					return Data;
				}
				
				
			}
			
			
			public void Local_Add(String table_name, ESM_Datatype Data) {
				// Add data to database on mobile device
				
				ContentValues Values = new ContentValues();
				
				
				//Switch case (Methode1, Methode2)
				
				//Values.put(key, value);
				//Values.put(key, value);
				//Values.put(key, value);
				//Values.put(key, value);
				//Values.put(key, value);
				
				SQLiteDatabase wdb = getWritableDatabase();
				
				//wdb.insert(table_name, nullColumnHack, values)
				
				//Online_Add();
				
				wdb.close(); 
			}
			
			public void Online_Add(String Table_name, ESM_Datatype Data) {
				
				
				// Add data to online database
				
				//IF TIMEOUTED:
				
				//Pending list (DATA_ID Local database - Checked)
				//Timer
				//Call Online_Add
				//Close
				
				//IF CONFIRMATION: 
				
				ContentValues Values = new ContentValues();
				
				//Values.put(key, value);
				
				SQLiteDatabase wdb = getWritableDatabase();
				
				//whereClause: the optional WHERE clause to apply when updating. Passing null will update all rows.
				//whereArgs:	You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings
				
				//wdb.update(Table_name, Values, whereClause, whereArgs)
				
				wdb.close();
				
			}
		
		
		
}
