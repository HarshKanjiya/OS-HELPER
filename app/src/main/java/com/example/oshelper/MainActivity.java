package com.example.oshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnFCFS,btnRR,btnPriority,btnDD,btnBankers,btnFirstFit,btnBestFit,btnWorstFit;
String subTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        btnFCFS = findViewById(R.id.btnFCFS);

        btnFirstFit = findViewById(R.id.btnFirstFit);
        btnWorstFit = findViewById(R.id.btnWorstFit);
        btnBestFit = findViewById(R.id.btnBestFit);

//      creating intents
        Intent input_fcfs_sjf_sjfp = new Intent(MainActivity.this,InputActivity.class);
        Intent input_firstFit = new Intent(MainActivity.this,InputActivity_fits.class);
        Intent input_bestFit = new Intent(MainActivity.this,InputActivity_fits.class);
        Intent input_worstFit = new Intent(MainActivity.this,InputActivity_fits.class);


        btnFCFS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subTitle = "First come First serve";
                Bundle subTitle_send = new Bundle();
                subTitle_send.putString("subTitle",subTitle);
                input_fcfs_sjf_sjfp.putExtras(subTitle_send);
                startActivity(input_fcfs_sjf_sjfp);
            }
        });


        btnFirstFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subTitle = "First Fit";
                Bundle subTitle_send = new Bundle();
                subTitle_send.putString("subTitle",subTitle);
                input_firstFit.putExtras(subTitle_send);
                startActivity(input_firstFit);
            }
        });
        btnBestFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subTitle = "Best Fit";
                Bundle subTitle_send = new Bundle();
                subTitle_send.putString("subTitle",subTitle);
                input_bestFit.putExtras(subTitle_send);
                startActivity(input_bestFit);
            }
        });
        btnWorstFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subTitle = "Worst Fit";
                Bundle subTitle_send = new Bundle();
                subTitle_send.putString("subTitle",subTitle);
                input_worstFit.putExtras(subTitle_send);
                startActivity(input_worstFit);
            }
        });

    }

}