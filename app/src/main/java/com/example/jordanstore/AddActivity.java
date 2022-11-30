package com.example.jordanstore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText brand_input, model_input, power_input;
    Button add_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        brand_input = findViewById(R.id.brand_input);
        model_input = findViewById(R.id.model_input);
        power_input = findViewById(R.id.power_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addCar(brand_input.getText().toString().trim(),
                        model_input.getText().toString().trim(),
                        Integer.valueOf(power_input.getText().toString().trim()));
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}