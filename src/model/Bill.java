package model;

import java.time.LocalDate;

public class Bill extends Product {
    private int idBill;
    private LocalDate dateBill;
    private String nameStaff;
    private String nameProduct;
    private double price;
    private int quantity;
    private double discount;
    private double totalAmount;

    public Bill() {
    }

    public Bill(int idBill, LocalDate dateBill, String nameStaff, String nameProduct, double price, int quantity, double discount, double totalAmount) {
        this.idBill = idBill;
        this.dateBill = dateBill;
        this.nameStaff = nameStaff;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.totalAmount = totalAmount;
    }

    public Bill(int idProduct, String nameProduct, String productCategory, double price, int quantity, int idBill, LocalDate dateBill, String nameStaff, String nameProduct1, double price1, int quantity1, double discount, double totalAmount) {
        super(idProduct, nameProduct, productCategory, price, quantity);
        this.idBill = idBill;
        this.dateBill = dateBill;
        this.nameStaff = nameStaff;
        this.nameProduct = nameProduct1;
        this.price = price1;
        this.quantity = quantity1;
        this.discount = discount;
        this.totalAmount = totalAmount;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public LocalDate getDateBill() {
        return dateBill;
    }

    public void setDateBill(LocalDate dateBill) {
        this.dateBill = dateBill;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    @Override
    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", dateBill=" + dateBill +
                ", nameStaff='" + nameStaff + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", totalAmount=" + totalAmount +
                "} " + super.toString();
    }
}
