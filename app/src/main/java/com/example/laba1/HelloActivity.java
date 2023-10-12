package com.example.laba1;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
public class HelloActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);

        TextView text1 = findViewById(R.id.text1);
        final int[] a = {0,0};

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[0]++;
                button1.setText("Нажато");
                text1.setText(String.valueOf(a[0])+","+String.valueOf(a[1]));
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[1]++;
                button2.setText("бим бом");
                text1.setText(String.valueOf(a[0])+","+String.valueOf(a[1]));
            }
        });

    }
}
