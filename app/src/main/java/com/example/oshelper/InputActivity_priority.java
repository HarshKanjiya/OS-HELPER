package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity_priority extends AppCompatActivity {
    EditText prno,arrival_time, burst_time,priority;
    Button clear,submit;
    int prno_int,arrivalTime_length,burstTime_length,priority_length;
    String[] arrivaltime_array,burstTime_array,priority_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_priority);

        prno = findViewById(R.id.num);
        arrival_time = findViewById(R.id.arrival_time);
        burst_time = findViewById(R.id.burst_time);
        clear = findViewById(R.id.btnClear);
        submit = findViewById(R.id.btnSubmit);
        priority = findViewById(R.id.priority);

//      creating intents
        Intent PRI = new Intent(InputActivity_priority.this,OutputActivity_priority.class);

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
                burst_time.setText(null);
                priority.setText(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priority_array = priority.getText().toString().split(",");
                arrivaltime_array = arrival_time.getText().toString().split(",");
                burstTime_array = burst_time.getText().toString().split(",");
                prno_int = Integer.parseInt(prno.getText().toString());
                priority_length = priority_array.length;
                arrivalTime_length = arrivaltime_array.length;
                burstTime_length = burstTime_array.length;


                if ((prno_int == arrivalTime_length) && (prno_int == burstTime_length) && (prno_int == priority_length)) {
//                  sending datta to priority output activity
                    Bundle data_Send_priority = new Bundle();
                    data_Send_priority.putInt("prno_int", prno_int);
                    data_Send_priority.putString("arrivalTime", arrival_time.getText().toString());
                    data_Send_priority.putString("burstTime", burst_time.getText().toString());
                    data_Send_priority.putString("priority_array",priority.getText().toString());
                    PRI.putExtras(data_Send_priority);
                    startActivity(PRI);
                } else {
                    Toast.makeText(InputActivity_priority.this, "number of Arrival time and number of Burst time are not equal to number of Processes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}