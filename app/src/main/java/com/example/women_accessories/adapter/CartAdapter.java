package com.example.women_accessories.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.women_accessories.R;
import com.example.women_accessories.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<Product> cartItemList;

    public CartAdapter(ArrayList<Product> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = cartItemList.get(position);
        holder.ItemCartImage.setImageResource(product.getImageResourceId());

        holder.textViewCartItemName.setText(product.getName());
        holder.textViewCartItemDetails.setText(String.format(Locale.getDefault(), "Size: %s | Color: %s | Price: $%.2f",
                product.getSize(), product.getColor(), product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCartItemName;
        TextView textViewCartItemDetails;
        ImageView ItemCartImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCartItemName = itemView.findViewById(R.id.textViewCartItemName);
            textViewCartItemDetails = itemView.findViewById(R.id.textViewCartItemDetails);
            ItemCartImage = itemView.findViewById(R.id.itemCartImageView);
        }
    }
}
