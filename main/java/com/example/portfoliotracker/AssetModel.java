package com.example.portfoliotracker;

public class AssetModel {
    private String cryptoName;
    private double cryptoPrice;
    private double quantity;
    private int id;

    // creating getter and setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public AssetModel(String cryptoName, double cryptoPrice, double quantity) {
        this.cryptoName = cryptoName;
        this.cryptoPrice = cryptoPrice;
        this.quantity = quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCryptoPrice() {
        return cryptoPrice;
    }

    public void setCryptoPrice(double cryptoPrice) {
        this.cryptoPrice = cryptoPrice;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public double getQuantity() {
        return quantity;
    }
}
