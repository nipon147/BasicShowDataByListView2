package com.example.nipon.basicshowdatabylistview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;


public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName = "db.Hero";
    private static final String tableName = "Customers";
    private static final int dbVersion = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName + "(CustomerID INTEGER PRIMARY KEY,FullName TEXT(100),GENDER TEXT(1),Address TEXT(200));");

        String sql1 = "INSERT INTO " + tableName + "(CustomerID,FullName,GENDER,Address) VALUES(111,'John','M','Bangkok Thailnad');";
        String sql2 = "INSERT INTO " + tableName + "(CustomerID,FullName,GENDER,Address) VALUES(222,'ELick','M','Bangkok Thailand');";
        String sql3 = "INSERT INTO " + tableName + "(CustomerID,FullName,GENDER,Address) VALUES(333,'SALA','F','Bangkok Thailand');";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);

    }//oncreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

        public ArrayList<HashMap<String, String>> getCustomerList() {
            try {
                ArrayList<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();
                HashMap<String, String> map;


                SQLiteDatabase db = this.getReadableDatabase();

                String sql = " SELECT * FROM " + tableName;
                Cursor cur = db.rawQuery(sql, null);

                if (cur!= null) {
                    if (cur.moveToFirst()) {
                        do {
                            map = new HashMap<String, String>();
                            map.put("CustomerID", cur.getString(0));
                            map.put("FullName", cur.getString(1));

                        } while (cur.moveToNext());




                    }//if2


                }//if1

                cur.close();
                db.close();
                return arr;


            } catch (Exception e) {
                return null;
                }//catch


        } //getCustomerList



}//main

