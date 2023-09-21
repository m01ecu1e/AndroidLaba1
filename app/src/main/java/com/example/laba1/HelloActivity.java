package com.example.laba1;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class HelloActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button1.setText("НАЖАТО!");
            }
        });
    }
}
