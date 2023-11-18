package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> {

            // Check if all fields are filled
            if (isFieldsEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Navigate to the product list screen
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                startActivity(intent);
            }

        });
    }

    private boolean isFieldsEmpty() {
        return editTextUsername.getText().toString().trim().isEmpty()
                || editTextEmail.getText().toString().trim().isEmpty()
                || editTextPassword.getText().toString().trim().isEmpty();
    }

}
