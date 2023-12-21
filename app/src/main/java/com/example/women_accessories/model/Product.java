package com.example.women_accessories.model;

import android.os.Parcel;
import android.os.Parcelable;


///treat this class just as normal model and don't give a fuck about "Parcelable" shit
// this is just to solve a problem related to passing objects from screen to another
public class Product implements Parcelable {

    private String title;
    private String size;
    private String color;
    private double price;

    private String image;

    public Product(String title, String size, String color, double price, String image) {
        this.title = title;
        this.size = size;
        this.color = color;
        this.price = price;
        this.image = image;
    }

    protected Product(Parcel in) {
        title = in.readString();
        size = in.readString();
        color = in.readString();
        price = in.readDouble();
        image = in.readString();
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
        dest.writeString(title);
        dest.writeString(size);
        dest.writeString(color);
        dest.writeDouble(price);
        dest.writeString(image);

    }

    public String getTitle() {
        return title;
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


    public String getImage() {
        return image;
    }
}

