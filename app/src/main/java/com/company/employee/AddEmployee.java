package com.company.employee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity {
            private EditText name,position,salary;
            private Button addEmployee;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        addEmployee=findViewById(R.id.InsertEmployee);
        addEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=findViewById(R.id.insertname);
                position=findViewById(R.id.inserposition);
                salary=findViewById(R.id.insertsalary);
                SQL sql=new SQL(AddEmployee.this);
                ContentValues contentValues=new ContentValues();
                if(!name.getText().toString().isEmpty()&&!position.getText().toString().isEmpty()&&
                        !salary.getText().toString().isEmpty()){
                contentValues.put("name" ,name.getText().toString());
                contentValues.put("position",position.getText().toString());
                contentValues.put("salary",salary.getText().toString());}
                SQLiteDatabase dp=sql.getWritableDatabase();
                Long data=dp.insert("Employee",null,contentValues);
                if (data!= -1  ){
                    AlertDialog.Builder alert=new AlertDialog.Builder(AddEmployee.this);
                    alert.setTitle("status").setMessage("done add succese ....").setNegativeButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            name.setText("");
                            position.setText("");
                            salary.setText("");
                        }
                    }).create().show();
                }else{
                    Toast.makeText(AddEmployee.this, "Enter data palese", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
