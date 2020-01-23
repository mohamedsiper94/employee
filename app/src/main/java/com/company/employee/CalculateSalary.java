package com.company.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class CalculateSalary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_salary);
        SQL sql=new SQL(this);
        SQLiteDatabase sqLiteDatabase=sql.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
         contentValues.put("id_day" , 5);
         contentValues.put("id_user",1);
         contentValues.put("detection",60);
        contentValues.put("additional",900);
       long x=  sqLiteDatabase.insert("nots",null,contentValues);
        Log.d("data","data is :" + x);

    }
}
