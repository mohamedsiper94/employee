package com.company.employee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQL extends SQLiteOpenHelper {

    public SQL(Context context) {
        super(context, "Employee", null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE employee(_id INTEGER PRIMARY KEY AUTOINCREMENT, name text , position text,salary int )");
        db.execSQL("CREATE TABLE attendence (id INTEGER PRIMARY KEY AUTOINCREMENT , currdate text,starttime text ,endtime text ,CONSTRAINT fk_departments FOREIGN KEY (id) REFERENCES employee(_id))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

 db.execSQL("CREATE TABLE nots(id_day INTEGER PRIMARY KEY AUTOINCREMENT,id_user  INTEGER , detection int , additional int , CONSTRAINT id_day FOREIGN KEY (id_day) REFERENCES  attendence (id),CONSTRAINT id_user FOREIGN KEY (id_user) REFERENCES employee(_id) )");

    }
}
