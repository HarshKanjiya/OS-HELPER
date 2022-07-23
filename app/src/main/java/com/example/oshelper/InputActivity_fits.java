package com.example.oshelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity_fits extends AppCompatActivity {
Button clear,submit;
EditText processSize,blockSize,prno;
int prno_int,pr_length,bl_length;
String blocks,processes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_fits);

        clear = findViewById(R.id.btnClear);
        submit = findViewById(R.id.btnSubmit);
        processSize = findViewById(R.id.process_in);
        blockSize = findViewById(R.id.block_in);
        prno = findViewById(R.id.num);


//      receiving subTitle
        Bundle subTitle_receive = getIntent().getExtras();
        String subTitle_string = subTitle_receive.getString("subTitle");

//      actionbar back button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setSubtitle(subTitle_string);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prno.setText(null);
                processSize.setText(null);
                blockSize.setText(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((!prno.getText().toString().equals(null)) && (!processSize.getText().toString().equals(null)) && (!blockSize.getText().toString().equals(null)))
                {

                    prno_int = Integer.parseInt(prno.getText().toString());
                    processes = processSize.getText().toString();
                    blocks = blockSize.getText().toString();
                    String[] pr_array = processSize.getText().toString().split(",");
                    String[] bl_array = blockSize.getText().toString().split(",");
                    pr_length = pr_array.length;
                    bl_length = bl_array.length;

                    if ((prno_int == pr_length)){

                        switch (subTitle_string) {
                            case "First Fit":
//                          sending datta to ff activity
                                Intent FF = new Intent(InputActivity_fits.this, OutputActivity_firstfit.class);
                                Bundle data_Send_ff = new Bundle();
                                data_Send_ff.putString("processSize", processSize.getText().toString());
                                data_Send_ff.putString("blockSize", blockSize.getText().toString());
                                data_Send_ff.putInt("prno_int", prno_int);
                                FF.putExtras(data_Send_ff);
                                startActivity(FF);
                                break;

                            case "Best Fit":
//                          sending datta to bf activity
                                Intent BF = new Intent(InputActivity_fits.this, OutputActivity_bestfit.class);
                                Bundle data_send_bf = new Bundle();
                                data_send_bf.putString("processSize", processSize.getText().toString());
                                data_send_bf.putString("blockSize", blockSize.getText().toString());
                                data_send_bf.putInt("prno_int", prno_int);
                                BF.putExtras(data_send_bf);
                                startActivity(BF);
                                break;

                            case "Worst Fit":
//                          sending datta to wf activity
                                Intent WF = new Intent(InputActivity_fits.this, OutputActivity_worstfit.class);
                                Bundle data_Send_WF = new Bundle();
                                data_Send_WF.putString("processSize", processSize.getText().toString());
                                data_Send_WF.putString("blockSize", blockSize.getText().toString());
                                data_Send_WF.putInt("prno_int", prno_int);
                                WF.putExtras(data_Send_WF);
                                startActivity(WF);
                                break;
                        }

                    } else {
                        Toast.makeText(InputActivity_fits.this, "number of Arrival time and number of Burst time are not equal to number of Processes!", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(InputActivity_fits.this, "Enter valid Inputs!", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
}