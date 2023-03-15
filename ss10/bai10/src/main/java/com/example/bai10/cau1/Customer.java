package com.example.bai10.cau1;

public class Customer {
    String name;
    String date;
    String address;
    String avatar;

    public Customer(String name, String date, String address, String avatar) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

