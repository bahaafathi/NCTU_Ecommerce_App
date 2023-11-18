package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);

        Button btnRegister = findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(v -> {
            // Navigate to the product list screen
            Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
            startActivity(intent);
        });
    }
}
