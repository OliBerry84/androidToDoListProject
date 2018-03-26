package com.example.cerberus.todolistproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cerberus on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "todolist.db";
    public static final String TABLE_NAME = "todolist_table";
    public static final String KEY_ID = "ID";
    public static final String KEY_TITLE = "JobTitle";
    public static final String KEY_DESCRIPTION = "JobDescription";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TITLE + " TEXT, " + KEY_DESCRIPTION + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }


    public boolean addJob(String jobTitle, String jobDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put(KEY_TITLE, jobTitle);
        Values.put(KEY_DESCRIPTION, jobDescription);
        long result = db.insert(TABLE_NAME, null, Values);
        if(result == -1)
            return false;
        else
            return true;
    }

}
