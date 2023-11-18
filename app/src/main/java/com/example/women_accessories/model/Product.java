package com.example.women_accessories.model;

public class Product {
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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", imageResourceId=" + imageResourceId +
                '}';
    }

}
