package model;

import java.util.List;

public class CartItem {
    private int id;
    private String nameProduct;
    private int quantity;
    private double price;
    private double totalAmount;

    public CartItem() {
    }

    public CartItem(int id, String nameProduct, int quantity, double price, double totalAmount) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = this.quantity*this.price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
