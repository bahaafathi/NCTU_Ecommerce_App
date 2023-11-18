package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.women_accessories.adapter.ProductAdapter;
import com.example.women_accessories.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {
    private static List<Product> productList = generateProductList();
    private ArrayList<Product> cartItemList = new ArrayList<>();
    private Button buttonShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        buttonShoppingCart = findViewById(R.id.buttonShoppingCart);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //the second parameter is a callback function ->>
        // * When a product is clicked, it is added to the shopping cart,
        // * and the shopping cart button text is updated.
        ProductAdapter adapter = new ProductAdapter(productList, product -> {
            addToCart(product);
            updateShoppingCartButtonText();
        });
        recyclerView.setAdapter(adapter);
    }


    private void addToCart(Product product) {
        cartItemList.add(product);
    }

    private void updateShoppingCartButtonText() {
        int cartSize = cartItemList.size();
        buttonShoppingCart.setText("Shopping Cart (" + cartSize + ")");
    }

    //this method will invoke when you press on the "Shopping Cart" Button
    public void viewShoppingCart(View view) {

        if (!cartItemList.isEmpty()) {
            Intent intent = new Intent(this, CartActivity.class);

            //passing all added CartItems to the Shopping Cart Screen
            intent.putParcelableArrayListExtra("cartItemList", new ArrayList<>(cartItemList));

            startActivity(intent);
        } else {
            Toast.makeText(this, "Shopping Cart is empty", Toast.LENGTH_SHORT).show();
        }
    }

    /// Generate a list of products with static data
    // Add more products as needed
    private static List<Product> generateProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Product 1", "Size 1", "Color 1", 19.99, R.drawable.product1));
        productList.add(new Product("Product 2", "Size 2", "Color 2", 29.99, R.drawable.product2));
        productList.add(new Product("Product 1", "Size 1", "Color 1", 19.99, R.drawable.product3));
        productList.add(new Product("Product 2", "Size 2", "Color 2", 29.99, R.drawable.product4));
        productList.add(new Product("Product 1", "Size 1", "Color 1", 19.99, R.drawable.product1));
        productList.add(new Product("Product 2", "Size 2", "Color 2", 29.99, R.drawable.product2));
        productList.add(new Product("Product 1", "Size 1", "Color 1", 19.99, R.drawable.product3));
        productList.add(new Product("Product 2", "Size 2", "Color 2", 29.99, R.drawable.product4));
        productList.add(new Product("Product 1", "Size 1", "Color 1", 19.99, R.drawable.product1));
        productList.add(new Product("Product 2", "Size 2", "Color 2", 29.99, R.drawable.product2));
        productList.add(new Product("Product 1", "Size 1", "Color 1", 19.99, R.drawable.product3));
        productList.add(new Product("Product 2", "Size 2", "Color 2", 29.99, R.drawable.product4));

        return productList;
    }
}
