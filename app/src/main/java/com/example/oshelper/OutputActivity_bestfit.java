package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class OutputActivity_bestfit extends AppCompatActivity {
    String[] processStr,blockStr;
    ListView processSize_list,blockSize_list,process_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_bestfit);

        processSize_list = findViewById(R.id.processSize);
        blockSize_list = findViewById(R.id.blockNumber);
        process_list= findViewById(R.id.process_list);


//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle("Best Fit");

        //      receiving data
        Bundle data_Receive = getIntent().getExtras();
        String blockStr = data_Receive.getString("blockSize");
        String processStr= data_Receive.getString("processSize");
        int prno_int = data_Receive.getInt("prno_int");
        String[] pr_a = processStr.toString().split(",");
        String[] bl_array = blockStr.toString().split(",");

//starting python
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python python = Python.getInstance();
        PyObject py = python.getModule("bestfit");
        PyObject ans =py.callAttr("main",prno_int,blockStr,processStr);

        String[] ans_array = ans.toString().split(",");
        String[] answer = new String[prno_int];
        for (int i =0 ; i<prno_int; i++){
            int x =Integer.parseInt(ans_array[i])-1;

            if ( x<0){
                answer[i] = "NA";
            }
            else{
                answer[i] = bl_array[x];
            }

        }

//        process name
        String[] pr_array = new String[prno_int];
        for(int i = 0 ; i< prno_int ; i++)
        {
            pr_array[i] = ""+(i+1);
        }

//        print
        ArrayAdapter name = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pr_array);
        process_list.setAdapter(name);
        ArrayAdapter at = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pr_a);
        processSize_list.setAdapter(at);
        ArrayAdapter bt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,answer);
        blockSize_list.setAdapter(bt);

    }
}