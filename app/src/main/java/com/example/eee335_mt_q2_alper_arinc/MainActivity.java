package com.example.eee335_mt_q2_alper_arinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE_ALARM = 1;
    Button btn_ok;
    EditText et_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_time = (EditText) findViewById(R.id.et_input);
        btn_ok = (Button) findViewById(R.id.btn_alper);

        btn_ok.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchFor = ((EditText) findViewById(R.id.et_input)).getText().toString();
                String alarm_title = "EEE335_Alper_Arinc";
                String input_time = et_time.getText().toString();

                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, alarm_title)
                        .putExtra(AlarmClock.EXTRA_LENGTH, Integer.parseInt(input_time))
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }



        });









    }


}