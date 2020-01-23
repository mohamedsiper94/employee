package com.company.employee;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Update_delete_Employee extends AppCompatActivity implements View.OnClickListener {
    private EditText name, salary;
    private Button update, delete;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQL sql = new SQL(this);
        sqLiteDatabase = sql.getWritableDatabase();
        setContentView(R.layout.activity_update_delete__employee);
        name = findViewById(R.id.updatename);
        salary = findViewById(R.id.updatesalary);
        update = findViewById(R.id.btnupdate);
        delete = findViewById(R.id.btndelete);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        name.setText(getIntent().getStringExtra("name"));
        salary.setText(String.valueOf(getIntent().getIntExtra("salary1", -5)));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnupdate:
                String name1 = name.getText().toString();
                String salary1 = salary.getText().toString();
                ContentValues values = new ContentValues();
                if (!name.getText().toString().isEmpty() && !salary.getText().toString().isEmpty()) {
                    values.put("name", name1);
                    values.put("salary", salary1);
                }
                String[] id = {"" + getIntent().getIntExtra("_id", -5)};
                int update = sqLiteDatabase.update("employee", values, "_id= ?", id);
                if (update != 0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(Update_delete_Employee.this);
                    alert.setTitle("Status").setMessage("Success").setNegativeButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            name.setText("");
                            salary.setText("");
                        }
                    }).create().show();
                } else {
                    Toast.makeText(this, "Error ", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btndelete:
                String[] id1 = {"" + getIntent().getIntExtra("_id", -1)};
                int delete = sqLiteDatabase.delete("employee", "_id=?", id1);
                if (delete != 0) {
                    Toast.makeText(this, "done delete", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "don't delete", Toast.LENGTH_SHORT).show();
                }
                name.setText("");
                salary.setText("");
                break;
        }
    }
}
