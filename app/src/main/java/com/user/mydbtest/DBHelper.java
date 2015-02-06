package com.user.mydbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.provider.BaseColumns._ID;
//這個是資料庫都會有個唯一的ID
/**
 * Created by user on 2015/2/6.
 */
public class DBHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "Students" ;
    public static final String NAME = "name" ;
    public static final String HEIGHT = "height" ;
    public static final String WEIGHT = "weight" ;
    public static final String AGE = "age" ;

    private final static String DATABASE_NAME = "demo.db";  //資料庫名稱
    private final static int DATABASE_VERSION = 1;  //資料庫版本

    public DBHelper(Context context){
        super(context , DATABASE_NAME ,null , DATABASE_VERSION) ;
    }

    @Override

    //建立table,有NAME、TEL、EMAIL 三個欄位

    public void onCreate(SQLiteDatabase db) {
        final String INIT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " CHAR, " + HEIGHT + " DOUBLE, " + WEIGHT + " DOUBLE," + AGE + "INTEGER" + ");" ;
        // CREATE TABLE Students  (
        //              _ID   INTEGER PRIMARY KEY AUTOINCREMENT ,
        //              name CHAR
        //              height  DOUBLE ,
        //              weight DOUBLE,
        //              age INTEGER
        // ) ;
        db.execSQL(INIT_TABLE);
        // db.execSQL(SQL語法)
    }

    @Override
    // 刪除 table
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){
        final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME ;
        db.execSQL(DROP_TABLE);
        onCreate(db) ;

    }
}
