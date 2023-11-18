package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.women_accessories.adapter.CartAdapter;
import com.example.women_accessories.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    private ArrayList<Product> cartItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve cart items from the intent
        if (getIntent().hasExtra("cartItemList")) {

            cartItemList = getIntent().getParcelableArrayListExtra("cartItemList");
            CartAdapter adapter = new CartAdapter(cartItemList);
            recyclerView.setAdapter(adapter);


            // Calculate and display the final price
            double finalPrice = calculateFinalPrice(cartItemList);
            TextView textViewFinalPrice = findViewById(R.id.textViewFinalPrice);
            textViewFinalPrice.setText(String.format(Locale.getDefault(), "Final Price: $%.2f", finalPrice));
        }


        // Handle the "Buy" button click
        Button btnBuy = findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, SuccessActivity.class);
            startActivity(intent);
        });

    }
    private double calculateFinalPrice(ArrayList<Product> cartItemList) {
        double totalPrice = 0;
        for (Product product : cartItemList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
