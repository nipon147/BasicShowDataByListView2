package com.example.nipon.basicshowdatabylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper db = new DBHelper(this, null, null, 0);
        final ArrayList<HashMap<String, String>> CustomerLits = db.getCustomerList();

        final ListView LsvCustomers = (ListView) findViewById(R.id.lsvCustomers);
        final SimpleAdapter adt = new SimpleAdapter(MainActivity.this,
                CustomerLits, R.layout.lsv_item,
                new String[]{"CustomerID","FullName"},
                new int[]{R.id.tvCustomerID,R.id.tvFullName});

        LsvCustomers.setAdapter(adt);
        LsvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strCustomerID = CustomerLits.get(position).get("CustomerID");
                String strFullName = CustomerLits.get(position).get("FullName");

                String str = strCustomerID + " " + strFullName;

                LsvCustomers.setAdapter(adt);
                LsvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String strCustomerID = CustomerLits.get(position).get("CustomerID");
                        String strFullName = CustomerLits.get(position).get("FullName");

                        String str = strCustomerID + " " + strFullName;
                        Toast.makeText(MainActivity.this, "Your select => " + str, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



    }//void







}//main
