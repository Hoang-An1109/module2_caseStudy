package model;

public class ProductCategory {
    private int id;
    private String name;

    public ProductCategory() {
    }

    public ProductCategory(int idProductCategory, String nameProductCategory) {
        this.id = idProductCategory;
        this.name = nameProductCategory;
    }

    public int getIdProductCategory() {
        return id;
    }

    public void setIdProductCategory(int id) {
        this.id = id;
    }

    public String getNameProductCategory() {
        return name;
    }

    public void setNameProductCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "idProductCategory=" + id +
                ", nameProductCategory='" + name + '\'' +
                '}';
    }
}
