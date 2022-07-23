package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class OutputActivity_sjf extends AppCompatActivity {
    ListView process_list,arrivalTime_list,burstTime_list,complitionTime_list,turnaroundTime_list,waitingTime_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_sjf);


        process_list = findViewById(R.id.process_list);
        arrivalTime_list = findViewById(R.id.arrivalTime_list);
        burstTime_list = findViewById(R.id.burstTime_list);
        complitionTime_list = findViewById(R.id.complitionTime_list);
        turnaroundTime_list = findViewById(R.id.turnaroundTime_list);
        waitingTime_list = findViewById(R.id.waitingTime_list);


//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle("Sortest Job First");



//      receiving data
        Bundle data_Receive = getIntent().getExtras();
        String arrivalTime = data_Receive.getString("arrivalTime");
        String burstTime= data_Receive.getString("burstTime");
        int prno_int = data_Receive.getInt("prno_int");

//starting python
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python python = Python.getInstance();
        PyObject fcfs = python.getModule("sjf");
        PyObject answer =fcfs.callAttr("main",prno_int,arrivalTime,burstTime);

        String[] answer_array = answer.toString().split(",");
        String[] ct=new String[prno_int];
        String[] tat=new String[prno_int];
        String[] wt=new String[prno_int];

        for (int i=0; i<prno_int;i++){
            ct[i]= answer_array[i];
            tat[i]= answer_array[i+prno_int];
            wt[i]= answer_array[i+(2*prno_int)];

        }
//        process name
        String[] pr_array = new String[prno_int];
        for(int i = 0 ; i< prno_int ; i++)
        {
            pr_array[i] = ""+(i+1);
        }


        String[] arrivalTime_array = arrivalTime.toString().split(",");
        String[] burstTime_array = burstTime.toString().split(",");
//        print
        ArrayAdapter name = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pr_array);
        process_list.setAdapter(name);
        ArrayAdapter at = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrivalTime_array);
        arrivalTime_list.setAdapter(at);
        ArrayAdapter bt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,burstTime_array);
        burstTime_list.setAdapter(bt);
        ArrayAdapter c = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ct);
        complitionTime_list.setAdapter(c);
        ArrayAdapter ta = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tat);
        turnaroundTime_list.setAdapter(ta);
        ArrayAdapter w = new ArrayAdapter(this, android.R.layout.simple_list_item_1,wt);
        waitingTime_list.setAdapter(w);


    }
}