package com.example.demo1.model;

public class Product {
    private int id ;
    private String name ;
    private double Price;
    private double Quantity;
    private String color;
    Category category;

    public Product(int id, String name, double price, double quantity, String color, Category category) {
        this.id = id;
        this.name = name;
        Price = price;
        Quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product() {
    }

    public Product(String name, double price, double quantity, String color, Category category) {
        this.name = name;
        Price = price;
        Quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
