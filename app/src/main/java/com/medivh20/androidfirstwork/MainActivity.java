package com.medivh20.androidfirstwork;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    private MaterialTextView tvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        tvNum = findViewById(R.id.tv_logo_num);
    }

    private void initEvent() {
        CountDownTimer cdt = new CountDownTimer(5 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TAG", "run: " + millisUntilFinished);
                        tvNum.setText(String.valueOf((millisUntilFinished+500) / 1000));
                    }
                });
            }

            @Override
            public void onFinish() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvNum.setText(String.valueOf(0));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                });
            }
        };
        cdt.start();

    }
}