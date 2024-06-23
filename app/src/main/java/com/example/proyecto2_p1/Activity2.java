package com.example.proyecto2_p1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private TextView tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        tv2 = findViewById(R.id.tv2);

        float res;
        Intent intent = getIntent();
        res = intent.getFloatExtra("res", 0);

        tv2.setText(String.valueOf(res));
    }
}
