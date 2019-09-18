package com.example.homebudget;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.DatePicker;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class expenses  extends AppCompatActivity {
    final DataBaseOfExpenses db = new DataBaseOfExpenses(expenses.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expenses_main);

        Intent c = getIntent();



       final  EditText ItemName = (EditText) findViewById(R.id.item);
    final     EditText price = (EditText) findViewById(R.id.money);
        Button button = (Button) findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                SimpleDateFormat obj=new SimpleDateFormat("dd/ MM / yyyy");

                String date=obj.format(calendar.getTime());
                String item = ItemName.getText().toString() + "\n";
                String expen = price.getText().toString();

                db.insertUserDetails(item, expen,date);
                // final  EditText bu=(EditText) findViewById(R.id.expenseid);
                //final  EditText bu=(EditText) findViewById(R.id.expenses);

                Toast.makeText(getApplicationContext(), "Expense Inserted Successsfully " , Toast.LENGTH_SHORT).show();

            }
        });


    }

}