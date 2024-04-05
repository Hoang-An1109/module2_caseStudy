package model;

public class ProductCategory {
    private int idProductCategory;
    private String nameProductCategory;

    public ProductCategory() {
    }

    public ProductCategory(int idProductCategory, String nameProductCategory) {
        this.idProductCategory = idProductCategory;
        this.nameProductCategory = nameProductCategory;
    }

    public int getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(int idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public String getNameProductCategory() {
        return nameProductCategory;
    }

    public void setNameProductCategory(String nameProductCategory) {
        this.nameProductCategory = nameProductCategory;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "idProductCategory=" + idProductCategory +
                ", nameProductCategory='" + nameProductCategory + '\'' +
                '}';
    }
}
