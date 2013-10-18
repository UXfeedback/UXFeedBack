import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LocalDatabase extends SQLiteOpenHelper {
	
	//TABLE 1
	String TABLE_NAME1 = "Methode 1";
	String ID_DATA = "ID_DATA";
	String ID_USER = "ID_USER";
	String DATA  = "DATA";
	String POSITION = "POSITION";
	String CHECK = "CHECK";
	String DATE = "DATE";
	
	//TABLE 2
	String TABLE_NAME2 = "Methode 2";
	
	//TABLE 3
	String TABLE_NAME3 = "Methode 3";
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
					+ " (" + ID_USER + " INTEGER,"
					+ AKTIVITY + "TEXT, "
					+ DATE + " DATETIME, "
					+ CHECK + " BOOL)";
			db.execSQL(Table3);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//we do something
		}
		
		
		public void Local_Add()
		{
			
		}
		
}
