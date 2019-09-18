package com.example.homebudget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.time.LocalDate;
import java.util.Date;


public class budget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_main);
        Intent a=getIntent();
        Button budgetbtn=(Button)findViewById(R.id.add);


       final  EditText editBudget=(EditText) findViewById(R.id.money2);


         budgetbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 DatabaseofBudget db= new DatabaseofBudget( budget.this);
                 String  budgetValue=editBudget.getText().toString();

                 Calendar calendar = Calendar.getInstance();

                 SimpleDateFormat obj=new SimpleDateFormat("dd/ MM / yyyy");

                 String date=obj.format(calendar.getTime());
                 db.insertUserDetails(budgetValue,date);

      Toast.makeText(getApplicationContext(),"Budget added Successfully  ",Toast.LENGTH_SHORT).show();
             }
         });




    }
}