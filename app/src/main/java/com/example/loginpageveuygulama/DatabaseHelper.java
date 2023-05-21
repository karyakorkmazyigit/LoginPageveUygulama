package com.example.loginpageveuygulama;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName="Signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context,"Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(name TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists allusers");

    }

    public Boolean insertData(String name,String password){
        SQLiteDatabase MyDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        long result = MyDatabase.insert("allusers",null,contentValues);

            if (result==-1){
                return false;
            }else{
                return true;
            }
    }
    public Boolean checkName(String name){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor=MyDatabase.rawQuery("Select * from allusers where name=?",new String[]{name});

        if (cursor.getCount()>0){
            return true;

        }else{
            return false;
        }
    }
    public Boolean checkNamePassword(String name,String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor=MyDatabase.rawQuery("Select * from allusers where name=? and password=?",new String[]{name,password});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
