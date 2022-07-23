package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class OutputActivity_rr extends AppCompatActivity {
    ListView process_list,arrivalTime_list,burstTime_list,complitionTime_list,turnaroundTime_list,waitingTime_list;
    TextView timeQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_rr);



        process_list = findViewById(R.id.process_list);
        arrivalTime_list = findViewById(R.id.arrivalTime_list);
        burstTime_list = findViewById(R.id.burstTime_list);
        complitionTime_list = findViewById(R.id.complitionTime_list);
        turnaroundTime_list = findViewById(R.id.turnaroundTime_list);
        waitingTime_list = findViewById(R.id.waitingTime_list);
        timeQ = findViewById(R.id.tq);


//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle("Round Robin");



//      receiving data
        Bundle data_Receive = getIntent().getExtras();
        String arrivalTime = data_Receive.getString("arrivalTime");
        String burstTime = data_Receive.getString("burstTime");
        int prno_int = data_Receive.getInt("prno_int");
        int timeQ_int = data_Receive.getInt("timeQ_int");

        String[] ct=new String[prno_int];
        String[] tat=new String[prno_int];
        String[] wt=new String[prno_int];



//algo
//        if (! Python.isStarted()) {
//            Python.start(new AndroidPlatform(this));
//        }
//        Python python = Python.getInstance();
//        PyObject fcfs = python.getModule("rr");
//        PyObject answer =fcfs.callAttr("main",prno_int,timeQ_int,arrivalTime,burstTime);
//
//        String[] ans_array = answer.toString().split(",");



//        for (int i=0; i<prno_int;i++){
//            ct[i]= ans_array[i];
//            tat[i]= ans_array[i+prno_int];
//            wt[i]= ans_array[i+(2*prno_int)];
//
//        }
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
        timeQ.setText("Time Quantum : "+timeQ_int);
//        ArrayAdapter c = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ct);
//        complitionTime_list.setAdapter(c);
//        ArrayAdapter ta = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tat);
//        turnaroundTime_list.setAdapter(ta);
//        ArrayAdapter w = new ArrayAdapter(this, android.R.layout.simple_list_item_1,wt);
//        waitingTime_list.setAdapter(w);


    }
}