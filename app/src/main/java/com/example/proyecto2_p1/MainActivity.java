package com.example.proyecto2_p1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    private TextView tv2;

    private EditText et1;

    private CheckBox cb1;

    private RadioButton rb1, rb2;

    private RadioGroup radioGroup;

    private Spinner spp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn1);
        tv2 = findViewById(R.id.tv2);
        et1 = findViewById(R.id.et1);
        cb1 = findViewById(R.id.cb1);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        radioGroup = findViewById(R.id.radioGroup);
        spp = findViewById(R.id.spp);
        radioGroup.setVisibility(View.INVISIBLE);

        String[] options = {"Contado", "Credito"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spp.setAdapter(adapter);
        spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selec = parent.getItemAtPosition(position).toString();
                    if (selec.equals("Contado")) {

                        tv2.setText("Contado");
                        radioGroup.setVisibility(View.INVISIBLE);

                    } else if (selec.equals("Credito")) {
                        tv2.setText("Credito");
                        radioGroup.setVisibility(View.VISIBLE);
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                float res = 0,precio, total;
                precio = Float.parseFloat(et1.getText().toString());

                if (spp.getSelectedItem().toString().equals("Credito")) {
                    total = precio + (precio * 0.12f);
                    if (rb1.isChecked()) {
                        if (cb1.isChecked()) {
                            res = (total / 12.0f) + (precio * 0.25f);
                            Intent intent = new Intent(MainActivity.this, Activity2.class);
                            intent.putExtra("res", res);
                            startActivity(intent);
                        }else {
                            res = total / 12.0f;
                            Intent intent = new Intent(MainActivity.this, Activity2.class);
                            intent.putExtra("res", res);
                            startActivity(intent);
                        }
                    } else if (rb2.isChecked()) {
                        if (cb1.isChecked()) {
                            res = (total / 24.0f) + (precio * 0.25f);
                            Intent intent = new Intent(MainActivity.this, Activity2.class);
                            intent.putExtra("res", res);
                            startActivity(intent);
                        }else {
                            res = total / 24.0f;
                            Intent intent = new Intent(MainActivity.this, Activity2.class);
                            intent.putExtra("res", res);
                            startActivity(intent);
                        }
                    }

                }else {
                    if (cb1.isChecked()) {
                        total = precio + (precio * 0.07f) + (precio * 0.25f);
                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                        intent.putExtra("res", total);
                        startActivity(intent);
                    } else {
                        total = precio + (precio * 0.07f);
                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                        intent.putExtra("res",total);
                        startActivity(intent);
                    }
                }

            }
        });

    }
}