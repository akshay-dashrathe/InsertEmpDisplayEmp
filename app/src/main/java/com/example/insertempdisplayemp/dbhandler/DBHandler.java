package com.example.insertempdisplayemp.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "coursedb";
    // below int is our database version
    private static final int DB_VERSION = 1;
    // below variable is for our table name.
    private static final String TABLE_NAME = "MyEmpDetails";
    // below variable is for our id column.
    private static final String ID_COL = "id";
    // below variable is for our course name column
    private static final String No_COL = "number";
    // below variable id for our course duration column.
    private static final String NAME_COL = "name";
    // below variable for our course description column.
    private static final String DESIGNATION_COL = "designation";
    // below variable is for our course tracks column.
    private static final String SALARY_COL = "salary";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + No_COL + " TEXT,"
                + NAME_COL + " TEXT,"
                + DESIGNATION_COL + " TEXT,"
                + SALARY_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addNewDetails(String Eno, String Ename, String Edesign, String Esalary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(No_COL, Eno);
        values.put(NAME_COL, Ename);
        values.put(DESIGNATION_COL, Edesign);
        values.put(SALARY_COL, Esalary);
        db.insert(TABLE_NAME, null, values);
        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}