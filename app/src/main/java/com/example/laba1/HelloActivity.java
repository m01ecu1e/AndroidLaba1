package com.example.laba1;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public class HelloActivity extends Activity {
    public int[] a = {0,0};
    long timeLeft = 15000;
    private TextView timerText;
    private TextView text1;
    CountDownTimer Timer1;
    boolean timerRunning;
    boolean timerStarted = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);

        text1 = findViewById(R.id.text1);
        timerText = findViewById(R.id.timerText);
        // = {0,0};


        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[0]++;
                button1.setText("Нажато");
                text1.setText(String.valueOf(a[0])+"  "+String.valueOf(a[1]));
                if (!timerStarted) startTimer();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[1]++;
                button2.setText("бим бом");
                text1.setText(String.valueOf(a[0])+"  "+String.valueOf(a[1]));
                if (!timerStarted) startTimer();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[0] = 0;
                a[1] = 0;
                stopTimer();
                text1.setText(String.valueOf(a[0])+"  "+String.valueOf(a[1]));
                timeLeft = 15000;
            }
        });
    }

    public void stopTimer() {
        Timer1.cancel();
        timerRunning = false;
        timerStarted = false;

    }

    public void updateTimer() {
        int seconds = (int) timeLeft % 60000 / 1000;

        timerText.setText(String.valueOf(seconds));
    }

    public void startTimer() {
        Timer1 = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }
            @Override
            public void onFinish() {
                if (a[0] > 2 && a[1] > 2) {
                    text1.setText("ПОБЕДА");
                }else {
                    text1.setText("GAMEOVER");
                }
                stopTimer();
            }
        }.start();
        timerRunning = true;
    }
}


