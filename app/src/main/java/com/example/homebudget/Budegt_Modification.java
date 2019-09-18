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



public class Budegt_Modification extends Activity implements OnClickListener  {

    private EditText budgettext;
    private Button updateBtn, deleteBtn;

    public int id1;

    private DatabaseofBudget dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.budget_modification);

        dbManager = new DatabaseofBudget(this);


        budgettext = (EditText) findViewById(R.id.money);


        updateBtn = (Button) findViewById(R.id.update);
        deleteBtn = (Button) findViewById(R.id.delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String money = intent.getStringExtra("price");

        id1 = Integer.parseInt(id);

        budgettext.setText(money);


        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update:
                String bname = budgettext.getText().toString();


                Calendar calendar = Calendar.getInstance();

                SimpleDateFormat obj=new SimpleDateFormat("dd/ MM / yyyy");



                String date=obj.format(calendar.getTime());

                dbManager.UpdateUserDetails( bname, date,id1);
                this.returnHome();
                break;

            case R.id.delete:
                dbManager.DeleteUser(id1);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), BudgetDetails.class);
        startActivity(home_intent);
    }
}