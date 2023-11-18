package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.women_accessories.adapter.CartAdapter;
import com.example.women_accessories.model.Product;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<Product> cartItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve cart items from the intent
        if (getIntent().hasExtra("cartItemList")) {
//            cartItemList = getIntent().getParcelableArrayListExtra("cartItemList") ;
//            cartItemList= (List<Product>) getIntent().getSerializableExtra("cartItemList");

//            CartAdapter adapter = new CartAdapter(cartItemList);
//            recyclerView.setAdapter(adapter);
        }
    }
}
