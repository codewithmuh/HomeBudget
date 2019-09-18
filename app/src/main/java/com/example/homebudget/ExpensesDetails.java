package com.example.homebudget;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tutlane on 05-01-2018.
 */

public class ExpensesDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.expenses_details);
        Button back=(Button) findViewById(R.id.btnBack);
        Intent intent=getIntent();

        DataBaseOfExpenses db = new DataBaseOfExpenses(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
      final  ListView lv = (ListView) findViewById(R.id.user_list);
        final ListAdapter adapter = new SimpleAdapter(ExpensesDetails.this, userList, R.layout.expenses_list,new String[]{"id","name","price","timestamp"}, new int[]{R.id.num,R.id.name, R.id.price,R.id.date});
        lv.setAdapter(adapter);

       


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 TextView numid=(TextView)view.findViewById(R.id.num);
                TextView itemtext=(TextView)view.findViewById(R.id.name);
                TextView Pricetext =(TextView)view.findViewById(R.id.price);


    long  valu= adapter.getItemId(i);

                String str = Long.toString(valu);
                String a =lv.getItemAtPosition(i).toString();
                String id=numid.getText().toString();
                String nameitem=itemtext.getText().toString();
                String priceitem=Pricetext.getText().toString();

                Toast.makeText(getApplicationContext(),id ,Toast.LENGTH_SHORT).show();//show the selected image in toast according to position

                Intent intent= new Intent(ExpensesDetails.this, Modification.class);
                intent.putExtra("id", id);
                intent.putExtra("item", nameitem);
                intent.putExtra("price", priceitem);
                startActivity(intent);
            }

        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ExpensesDetails.this, Modification.class);
                startActivity(intent);
            }
        });

    }
}