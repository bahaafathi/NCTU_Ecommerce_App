package com.example.women_accessories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.women_accessories.ApiService.ApiService;
import com.example.women_accessories.adapter.ProductAdapter;
import com.example.women_accessories.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductListActivity extends AppCompatActivity {
    private ArrayList<Product> cartItemList = new ArrayList<>();
    private Button buttonShoppingCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        buttonShoppingCart = findViewById(R.id.buttonShoppingCart);


        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of API interface
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Product> productList = response.body();
                    // Now, you can update your RecyclerView with the productList
                    // Create an adapter and set it to the RecyclerView

                    productList.forEach(product -> System.out.println(product.getImage()));


                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ProductListActivity.this));
                    //the second parameter is a callback function ->>
                    // * When a product is clicked, it is added to the shopping cart,
                    // * and the shopping cart button text is updated.
                    ProductAdapter adapter = new ProductAdapter(productList, product -> {
                        addToCart(product);
                        updateShoppingCartButtonText();
                    });
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductListActivity.this, "Failure",
                        Toast.LENGTH_SHORT).show();
            }

        });


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


}
