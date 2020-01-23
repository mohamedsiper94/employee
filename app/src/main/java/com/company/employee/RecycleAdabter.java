package com.company.employee;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdabter extends RecyclerView.Adapter<RecycleAdabter.ViewHoldeer> {
         private Context context;
          private ArrayList<Employee> arrayList;

    public RecycleAdabter(Context context, ArrayList<Employee> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public class ViewHoldeer extends RecyclerView.ViewHolder {
        private TextView name,position;
        public ViewHoldeer(@NonNull View itemView) {
            super(itemView);
          name=itemView.findViewById(R.id.text_name);
          position=itemView.findViewById(R.id.text_position);
        }
    }

    @NonNull
    @Override
    public ViewHoldeer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.showdetail,parent,false);
        return new ViewHoldeer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldeer holder, final int position) {
        SQL sql=new SQL(context);
        final SQLiteDatabase sqLiteDatabase=sql.getReadableDatabase();
        final Employee employe=arrayList.get(position);
        holder.name.setText("name: "+employe.getName());
        holder.position.setText("position: "+employe.getPosition());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert=new AlertDialog.Builder(context);
                alert.setTitle("Chose from following Options").setPositiveButton("Updtate Employee", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         String name=employe.getName();
                        String [] selection={name};
                      Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE name = ?",selection);
                        if (cursor.moveToNext()){
                        Intent intent=new Intent(context,Update_delete_Employee.class);
                        intent.putExtra("name", name);
                        intent.putExtra("_id",cursor.getInt(0));
                        intent.putExtra("salary1",cursor.getInt(3));
                        context.startActivity(intent);
                    }}
                }).setIcon(R.drawable.schapcircle).setNegativeButton("Calculate Salary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                           Intent intent=new Intent(context,CalculateSalary.class);
                           context.startActivity(intent);
                    }
                }).create().show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
