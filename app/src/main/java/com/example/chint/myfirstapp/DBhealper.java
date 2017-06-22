package com.example.chint.myfirstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by chint on 6/16/2017.
 */

public class DBhealper extends SQLiteOpenHelper {
    private static String DBNAME = "mydb";
    public DBhealper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PASSWORD TEXT, PHONE NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    public void onRegisterClicked(String a, String b, String c){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO USERS (NAME, PASSWORD, PHONE) VALUES ('"+a+"', '"+b+"', '"+c+"')");
    }

    public String onLoginClicked(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        //String s = db.execSQL("SELECT PASSWORD FROM USERS WHERE NAME = '"+a+"'");
        //Cursor cursor = db.rawQuery("SELECT PASSWORD FROM USERS WHERE NAME = '"+a+"'",null);
        Cursor cursor = db.rawQuery("SELECT NAME, PASSWORD FROM USERS",null);
        String b,c;
        c = "Not Found";
        if(cursor.moveToFirst()) {
            do {
                b = cursor.getString(0);
                if (b.equals(a)) {
                    c = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return c;
    }
}
