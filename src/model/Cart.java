package model;

import java.util.List;

public class Cart {
    private int id;
    private String nameStaff;
    private List<CartItem> cart;
    private double totalAmout;

    public Cart() {
    }

    public Cart(int id, String nameStaff, List<CartItem> cart, double totalAmout) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.cart = cart;
        this.totalAmout = totalAmout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    public double getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(double totalAmout) {
        this.totalAmout = totalAmout;
    }
}
