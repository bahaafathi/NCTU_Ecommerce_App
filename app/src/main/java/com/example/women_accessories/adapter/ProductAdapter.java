package com.example.women_accessories.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.women_accessories.R;
import com.example.women_accessories.model.Product;

import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Product product);
    }
    public ProductAdapter(List<Product> productList, OnItemClickListener listener) {
        this.productList = productList;
        this.listener = listener;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.imageViewProduct.setImageResource(product.getImageResourceId());
        holder.textViewName.setText(product.getName());
        holder.textViewDetails.setText(String.format(Locale.getDefault(), "Size: %s | Color: %s | Price: $%.2f",
                product.getSize(), product.getColor(), product.getPrice()));

        holder.buttonAddToCart.setOnClickListener(v -> listener.onItemClick(product));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewName;
        TextView textViewDetails;
        Button buttonAddToCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDetails = itemView.findViewById(R.id.textViewDetails);
            buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart);
        }
    }
}
