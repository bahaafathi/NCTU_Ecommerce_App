package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

// VisaDetailsActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VisaDetailsActivity extends AppCompatActivity {

    private EditText editTextVisaNumber;
    private EditText editTextVisaType;
    private EditText editTextIssueDate;
    private EditText editTextPlaceOfIssue;
    private Spinner spinnerCountry;
    private TransitionReceiver transitionReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_details);

        // Create an instance of the TransitionReceiver
        transitionReceiver = new TransitionReceiver();

        // Create an IntentFilter to specify the broadcast action to listen for
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_ACTIVITY_TRANSITION");

        // Register the receiver dynamically
        registerReceiver(transitionReceiver, intentFilter);

        editTextVisaNumber = findViewById(R.id.editTextVisaNumber);
        editTextVisaType = findViewById(R.id.editTextVisaType);
        editTextIssueDate = findViewById(R.id.editTextIssueDate);
        editTextPlaceOfIssue = findViewById(R.id.editTextPlaceOfIssue);


        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(view -> {
            Toast.makeText(this, "Thank You ", Toast.LENGTH_LONG).show();

            Intent transitionIntent = new Intent("android.intent.action.ACTION_ACTIVITY_TRANSITION");
            sendBroadcast(transitionIntent);


        });
    }


}
