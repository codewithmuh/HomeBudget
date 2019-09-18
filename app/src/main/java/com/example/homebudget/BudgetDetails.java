package com.example.homebudget;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;


public  class BudgetDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.budget_details);

        Button back =(Button) findViewById(R.id.btnback);

        Intent intent=getIntent();
        DatabaseofBudget db=new DatabaseofBudget(this);
       final ArrayList<HashMap<String ,String >> userlist=db.GetUsers();
        final ListView lv = (ListView) findViewById(R.id.user_list1);
       final  ListAdapter adapter = new SimpleAdapter(BudgetDetails.this, userlist, R.layout.budget_list,new String[]{"id","name","timestamp"}, new int[]{R.id.num,R.id.name, R.id.date});
        lv.setAdapter(adapter);
        // ListView on item selected listener.
        //perform listView item click event
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView numid=(TextView)view.findViewById(R.id.num);
                TextView budgettext=(TextView)view.findViewById(R.id.name);



                long  valu= adapter.getItemId(i);

                String str = Long.toString(valu);
                String a =lv.getItemAtPosition(i).toString();
                String id=numid.getText().toString();
                String budget=budgettext.getText().toString();


                Toast.makeText(getApplicationContext(),id ,Toast.LENGTH_SHORT).show();//show the selected image in toast according to position

                Intent intent= new Intent(BudgetDetails.this, Budegt_Modification.class);
                intent.putExtra("id", id);
                intent.putExtra("price", budget);

                startActivity(intent);
            }
        });

    }
}




