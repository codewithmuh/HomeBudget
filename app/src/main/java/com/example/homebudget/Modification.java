package com.example.homebudget;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.Calendar;
import java.text.SimpleDateFormat;



public class Modification extends Activity implements OnClickListener  {

    private EditText itemtext;
    private Button updateBtn, deleteBtn;
    private EditText pricetext;

  public int id1;

    private DataBaseOfExpenses dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.modification_data);

        dbManager = new DataBaseOfExpenses(this);


        itemtext = (EditText) findViewById(R.id.item);
        pricetext= (EditText) findViewById(R.id.money);

        updateBtn = (Button) findViewById(R.id.update);
        deleteBtn = (Button) findViewById(R.id.delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("item");
        String price = intent.getStringExtra("price");
         id1 = Integer.parseInt(id);

        itemtext.setText(name);
        pricetext.setText(price);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update:
                String nameitem = itemtext.getText().toString();
                String priceitem = pricetext.getText().toString();

                Calendar calendar = Calendar.getInstance();

                SimpleDateFormat obj=new SimpleDateFormat("dd/ MM / yyyy");




                String date=obj.format(calendar.getTime());

                dbManager.UpdateUserDetails( nameitem , priceitem, date,id1);
                this.returnHome();
                break;

            case R.id.delete:
                dbManager.DeleteUser(id1);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ExpensesDetails.class);
        startActivity(home_intent);
    }
}