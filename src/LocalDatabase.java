import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LocalDatabase extends SQLiteOpenHelper {
	
	//TABLE 1
		String TABLE_NAME1 = "Methode_1";
		String ID_DATA = "ID_DATA";
		String ID_USER = "ID_USER";
		String DATA  = "DATA";
		String POSITION = "POSITION";
		String CHECK = "CHECK";
		String DATE = "DATE";
		
		//TABLE 2
		String TABLE_NAME2 = "Methode_2";
		
		//TABLE 3
		String TABLE_NAME3 = "USE_DATA";
		String AKTIVITY = "AKTIVITY";
		
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
						 + CHECK + " BOOL)";
				 
				 db.execSQL(Table1);
				 
				 String Table2 = "CREATE TABLE " + TABLE_NAME2
						 + " (" + ID_DATA + "INTEGER PRIMARY AUTOINCREMENT,"
						 + ID_USER + " INTEGER,"
						 + DATA + " TEXT,"
						 + CHECK + " BOOL)";
				db.execSQL(Table2);
				
				String Table3 = "CREATE TABLE " + TABLE_NAME3
						+ " (" + ID_DATA + "INTEGER PRIMARY AUTOINCREMENT,"
						+ ID_USER + " INTEGER,"
						+ AKTIVITY + "TEXT, "
						+ DATE + " DATETIME, "
						+ CHECK + " BOOL)";
				db.execSQL(Table3);
			}
			
			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//we do something
			}
			
			public void Sync(String table_name, int ID) {
				
				SQLiteDatabase rdb = getReadableDatabase();
				// Query: Find den sidste fra denne brugers tilføjet
				String query = "SELECT * FROM " + table_name 
						+ "WHERE " + ID_DATA + " = " 
						+ ("SELECT MAX(ID_DATA) FROM " + table_name);
				
				Cursor c = rdb.rawQuery(query, null);
				c.moveToFirst();
				// Data access object 

				//if checked true

				//Call Local_Add

				//else
				
				//Call Online_Add
				
			}
			
			
			public void Local_Add(String table_name) {
				// Add data to database on mobile device
				
				ContentValues Values = new ContentValues();
				
				
				//Switch case (Methode1, Methode2)
				
				//Values.put(key, value);
				//Values.put(key, value);
				//Values.put(key, value);
				//Values.put(key, value);
				//Values.put(key, value);
				
				SQLiteDatabase wdb = getWritableDatabase();
				
				wdb.insert(table_name, nullColumnHack, values)
				
				Online_Add();
				
				wdb.close(); 
			}
			
			public void Online_Add(String Table_name, Boolean Check, int ID, int Data, String Position) {
				
				
				// Add data to online database
				
				//IF TIMEOUTED:
				
				//Pending list (DATA_ID Local database - Checked)
				//Timer
				//Call Online_Add
				//Close
				
				//IF CONFIRMATION: 
				
				ContentValues Values = new ContentValues();
				
				Values.put(key, value);
				
				SQLiteDatabase wdb = getWritableDatabase();
				
				//whereClause: the optional WHERE clause to apply when updating. Passing null will update all rows.
				//whereArgs:	You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings
				
				wdb.update(Table_name, Values, whereClause, whereArgs)
				
				wdb.close();
				
			}
		
		
		
}
