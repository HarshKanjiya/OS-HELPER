package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;

public class InputActivity extends AppCompatActivity {
EditText prno,arrival_time, burst_time;
Button clear,submit;
int prno_int,arrivalTime_length,burstTime_length;
String arrivalTime,burstTime;
String[] arrivaltime_array,burstTime_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        prno = findViewById(R.id.num);
        arrival_time = findViewById(R.id.arrival_time);
        burst_time = findViewById(R.id.burst_time);
        clear = findViewById(R.id.btnClear);
        submit = findViewById(R.id.btnSubmit);

//      creating intents
        Intent FCFS = new Intent(InputActivity.this,OutputActivity_fcfs.class);

//      receiving subTitle
        Bundle subTitle_receive = getIntent().getExtras();
        String subTitle_string = subTitle_receive.getString("subTitle");

//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle(subTitle_string);

//      creating listeners

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 prno.setText(null);
                 arrival_time.setText(null);
                 burst_time.setText(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((!prno.getText().toString().equals(null)) && (!arrival_time.getText().toString().equals(null)) && (!burst_time.getText().toString().equals(null)))
                {

                    arrivaltime_array = arrival_time.getText().toString().split(",");
                    burstTime_array = burst_time.getText().toString().split(",");
                    prno_int = Integer.parseInt(prno.getText().toString());
                    arrivalTime_length = arrivaltime_array.length;
                    burstTime_length = burstTime_array.length;


                    if ((prno_int == arrivalTime_length) && (prno_int == burstTime_length)) {


//                      sending datta to fcfs activity
                        Bundle data_Send_fcfs = new Bundle();
                        data_Send_fcfs.putString("arrivalTime", arrival_time.getText().toString());
                        data_Send_fcfs.putString("burstTime",burst_time.getText().toString());
                        data_Send_fcfs.putInt("prno_int", prno_int);
                        FCFS.putExtras(data_Send_fcfs);
                        startActivity(FCFS);
                    } else {
                        Toast.makeText(InputActivity.this, "number of Arrival time and number of Burst time are not equal to number of Processes!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(InputActivity.this, "Enter valid Inputs!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}