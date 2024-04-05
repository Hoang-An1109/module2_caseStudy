package model;

public class Product extends ProductCategory{
    private int idProduct;
    private String nameProduct;
    private String nameProductCategory;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String productCategory, double price, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameProductCategory = productCategory;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int idProductCategory, String nameProductCategory, int idProduct, String nameProduct, String nameProductCategory1, double price, int quantity) {
        super(idProductCategory, nameProductCategory);
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameProductCategory = nameProductCategory1;
        this.price = price;
        this.quantity = quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProductCategory() {
        return nameProductCategory;
    }

    public void setNameProductCategory(String nameProductCategory) {
        this.nameProductCategory = nameProductCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", productCategory='" + nameProductCategory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                "} " + super.toString();
    }
}
