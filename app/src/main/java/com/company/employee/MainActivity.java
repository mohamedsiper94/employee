package com.company.employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rbddevs.splashy.Splashy;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button listEmployee, addEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Splashy(MainActivity.this)
                .setLogo(R.drawable.ic_person_black_24dp)
                .setTitle("Employee")
                .setTitleColor(R.color.colorText)
                .setSubTitle("Shehab.org")
                .setProgressColor(R.color.colorText).showProgress(true)
                .setBackgroundResource(R.drawable.shabeone)
                .setFullScreen(true)
                .setTime(5000)
                .show();
        listEmployee = findViewById(R.id.listofemployee);
        addEmployee = findViewById(R.id.addemployee);
        listEmployee.setOnClickListener(this);
        addEmployee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addemployee:
                Intent intent = new Intent(MainActivity.this, AddEmployee.class);
                startActivity(intent);
                break;
            case R.id.listofemployee:
                Intent list = new Intent(MainActivity.this, List_Employee.class);
                startActivity(list);
                break;
        }
    }
}
