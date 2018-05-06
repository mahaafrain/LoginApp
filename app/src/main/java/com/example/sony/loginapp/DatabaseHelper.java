package com.example.sony.loginapp;

import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db",  null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    public boolean insert(String username, String password)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValue= new ContentValues();
        contentValue.put("username", username);
        contentValue.put("password",password);
        long insrt= db.insert("user",null,contentValue);
        if (insrt==-1)
            return false;
        else return true;}

    public boolean CheckUsername(String username)
    { SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("Select * from user where username=?",new String[]{username});
        if (cursor.getCount()>0)
            return false;
        else return true;}


    public boolean UserPassCheck(String username, String password)
    {SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        if (cursor.getCount()>0) return true;
        else return false;

    }
}