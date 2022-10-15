package com.gergeo.faster_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String db_name = "login.db";

    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users (username TEXT primary key, password  TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
    }

    public boolean insertData(String username , String password){
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username" ,username);
            contentValues.put("password", password);
            long result = sqLiteDatabase.insert("users",null,contentValues);
            if (result == -1 ) return false;
            else return true ;
    }

    public boolean CheckUserName(String username){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ?",new String[] {username});
        if ( cursor.getCount() > 1 ){
            return true;
        }
        else
            return  false;
    }

    public boolean CheckUserNamePassword(String username , String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ? and password = ? ",new String[] {username,password});
        if (cursor.getCount() >0){
            return true;
        }
        else return false;


    }
}
