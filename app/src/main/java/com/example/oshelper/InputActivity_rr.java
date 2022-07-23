package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity_rr extends AppCompatActivity {
    EditText prno,arrival_time, burstTime,timeQ;
    Button clear,submit;
    int prno_int,arrivalTime_length,burstTime_length;
    String[] arrivaltime_array,burstTime_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_rr);

        prno = findViewById(R.id.num);
        arrival_time = findViewById(R.id.arrival_time);
        burstTime = findViewById(R.id.burst_time);
        clear = findViewById(R.id.btnClear);
        submit = findViewById(R.id.btnSubmit);
        timeQ = findViewById(R.id.timeQuontom);


//      creating intents
        Intent rr = new Intent(InputActivity_rr.this, OutputActivity_rr.class);


//      receiving subTitle
        Bundle subTitle_receive = getIntent().getExtras();
        String subTitle_string = subTitle_receive.getString("subTitle");


//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle(subTitle_string);


//        creating listeners
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prno.setText(null);
                arrival_time.setText(null);
                burstTime.setText(null);
                timeQ.setText(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    arrivaltime_array = arrival_time.getText().toString().split(",");
                    burstTime_array = burstTime.getText().toString().split(",");
                    prno_int = Integer.parseInt(prno.getText().toString());
                    arrivalTime_length = arrivaltime_array.length;
                    burstTime_length = burstTime_array.length;
                    int timeQ_int = Integer.parseInt(timeQ.getText().toString());

                    if ((!prno.getText().toString().equals(null)) && (!timeQ.getText().toString().equals(null)) ){
//                  sending datta to priority output activity
                        Bundle data_Send_rr = new Bundle();
                        data_Send_rr.putInt("prno_int", prno_int);
                        data_Send_rr.putInt("timeQ_int",timeQ_int);
                        data_Send_rr.putString("arrivalTime", arrival_time.getText().toString());
                        data_Send_rr.putString("burstTime", burstTime.getText().toString());
                        rr.putExtras(data_Send_rr);
                        startActivity(rr);
                    }
                    else
                    {
                        Toast.makeText(InputActivity_rr.this, "number of Arrival time and number of Burst time are not equal to number of Processes!", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}