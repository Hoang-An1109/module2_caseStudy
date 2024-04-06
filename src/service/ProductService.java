package service;

import model.Product;
import model.ProductCategory;
import storage.productStorage.IProductStorage;
import storage.productStorage.ReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IService<Product> {
    Scanner scanner = new Scanner(System.in);
    private static IProductStorage iProductStorage = ReadWriteFile.getInstance();
    private static List<Product> productList = iProductStorage.readFile();

    @Override
    public void add() throws InterruptedException {
        System.out.println("__________Thêm Sản Phẩm__________");
        System.out.print("Nhập ID sản phẩm: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tên danh mục sản phẩm: ");
        String nameCategory = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        Double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        productList.add(new Product(id, name, nameCategory, price, quantity));

        ReadWriteFile.getInstance().writeFile(productList);
        System.out.println("Bạn đã thêm sản phẩm thành công.");
        System.out.println();
    }

    @Override
    public void edit() throws InterruptedException {
        System.out.println("__________Chỉnh Sửa Sản Phẩm__________");
        System.out.print("Nhập mã sản phẩm mà bạn muốn chỉnh sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product productToEdit = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                productToEdit = product;
                break;
            }
        }

        if (productToEdit == null) {
            System.out.println("Không tìm thấy mã sản phẩm cần chỉnh sửa trong danh sách sản phẩm.");
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String newName = scanner.nextLine();

        System.out.print("Nhập tên danh mục sản phẩm: ");
        String newNameCategory = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập số lượng sản phẩm: ");
        int newQuantity = scanner.nextInt();

        productToEdit.setName(newName);
        productToEdit.setNameProductCategory(newNameCategory);
        productToEdit.setPrice(newPrice);
        productToEdit.setQuantity(newQuantity);

        ReadWriteFile.getInstance().writeFile(productList);
        System.out.print("Đã chỉnh sửa sản phẩm thành công.");
        System.out.println();
    }

    @Override
    public void delete() throws InterruptedException {
        System.out.println("__________Xóa Sản Phẩm__________");
        System.out.print("Nhập mã sản phẩm mà bạn muốn xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean remove = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                remove = true;
                break;
            }
        }

        if (remove) {
            storage.productStorage.ReadWriteFile.getInstance().writeFile(productList);
            System.out.println("Đã xóa thành công.");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm cần xóa trong danh sách sản phẩm.");
        }
        System.out.println();
    }

    @Override
    public void show() throws InterruptedException {
        System.out.printf("| %-10s | %-40s | %-40s | %-20s | %-20s | %n", "ID", "NAME", "NAME CATEGORY", "PRICE", "QUANTITY");
        for (Product product : productList) {
            System.out.printf("| %-10s | %-40s | %-40s | %-20s | %-20s | %n", product.getId(),product.getName(),product.getNameProductCategory(),product.getPrice(),product.getQuantity());
        }
        System.out.println();
    }

    @Override
    public void findById() throws InterruptedException {

    }

    @Override
    public void findByName() throws InterruptedException {

    }
}
