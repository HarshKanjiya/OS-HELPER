package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class OutputActivity_dd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_dd);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("Deadlock Detection");

        //      receiving data
        Bundle data_Receive = getIntent().getExtras();
        String allocations = data_Receive.getString("allocations");
        String requests = data_Receive.getString("requests");
        int prno_int = data_Receive.getInt("prno_int");

        Python python = Python.getInstance();
        PyObject dd = python.getModule("dd");
        PyObject answer =dd.callAttr("main",prno_int,allocations,requests);



    }
}