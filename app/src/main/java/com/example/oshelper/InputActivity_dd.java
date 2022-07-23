package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity_dd extends AppCompatActivity {
    EditText prno,allocations,requests;
    Button clear,submit;
    int prno_int,allocations_length,requests_length;
    String[] allocations_array,requests_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_dd);

        prno = findViewById(R.id.num);
        allocations = findViewById(R.id.allocations);
        requests = findViewById(R.id.requests);
        clear = findViewById(R.id.btnClear);
        submit = findViewById(R.id.btnSubmit);


//      receiving subTitle
        Bundle subTitle_receive = getIntent().getExtras();
        String subTitle_string = subTitle_receive.getString("subTitle");


//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle(subTitle_string);
//

//        creating listeners
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prno.setText(null);
                allocations.setText(null);
                requests.setText(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allocations_array = allocations.getText().toString().split(",");
                requests_array = requests.getText().toString().split(",");
                allocations_length = allocations_array.length;
                requests_length = requests_array.length;

                Intent to_dd = new Intent(InputActivity_dd.this, OutputActivity_dd.class);
//                  sending datta to dd output activity
                Bundle send_data = new Bundle();
                send_data.putString("allocations", allocations.getText().toString());
                send_data.putString("requests", requests.getText().toString());
                to_dd.putExtras(send_data);
                startActivity(to_dd);
            }
        });

//
    }
}