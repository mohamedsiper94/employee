package com.company.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class List_Employee extends AppCompatActivity {
       private RecyclerView listEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__employee);
        listEmployee=findViewById(R.id.listEmployee);



    }

    @Override
    protected void onResume() {
        super.onResume();
        SQL sql=new SQL(this);
        Log.d("ddd","sqlname is :"+ sql.getDatabaseName());
        SQLiteDatabase sqLiteDatabase=sql.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM employee",null);

        ArrayList<Employee> arrayList=new ArrayList<>();
        for (int i=0;i<cursor.getCount();i++){
            if (cursor.moveToNext()){
                String name =cursor.getString(1);
                String position=cursor.getString(2);
                int salary=cursor.getInt(3);
                Employee employee=new Employee(name,position,salary);

                arrayList.add(employee);
            }
        }
        RecycleAdabter recycleAdabter=new RecycleAdabter(List_Employee.this,arrayList);
        listEmployee.setLayoutManager(new LinearLayoutManager(List_Employee.this));
        listEmployee.setAdapter(recycleAdabter);


    }
}
