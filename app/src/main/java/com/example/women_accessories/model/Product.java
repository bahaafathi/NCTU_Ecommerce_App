package com.example.women_accessories.model;

import android.os.Parcel;
import android.os.Parcelable;


///treat this class just as normal model and don't give a fuck about "Parcelable" shit
// this is just to solve a problem related to passing objects from screen to another
public class Product implements Parcelable {

    private String name;
    private String size;
    private String color;
    private double price;
    private int imageResourceId;

    public Product(String name, String size, String color, double price, int imageResourceId) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    protected Product(Parcel in) {
        name = in.readString();
        size = in.readString();
        color = in.readString();
        price = in.readDouble();
        imageResourceId = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(size);
        dest.writeString(color);
        dest.writeDouble(price);
        dest.writeInt(imageResourceId);
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}

