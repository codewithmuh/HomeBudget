package com.example.homebudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView card_view1 = (CardView) findViewById(R.id.budget_view1);
        // creating a CardView and assigning a value.
       CardView card_view2=(CardView) findViewById(R.id.expenses_view);
        CardView card_view3 = (CardView) findViewById(R.id.card_view3);

        CardView card_view4=(CardView) findViewById(R.id.card_view4);
        CardView card_view5 = (CardView) findViewById(R.id.card_view5);

        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,budget.class);
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
           startActivity(intent);
            }
        });
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_expenses=new Intent(MainActivity.this,expenses.class);
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                startActivity(intent_expenses);
            }
        });
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,BudgetDetails.class);
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                startActivity(intent);
            }
        });
        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_expenses=new Intent(MainActivity.this, ExpensesDetails.class);
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
                startActivity(intent_expenses);
            }
        });
    }
}
