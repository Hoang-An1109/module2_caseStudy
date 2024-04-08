package service;

import model.ProductCategory;
import storage.productCategoryStorage.ReadWriteFileCategory;

import java.util.List;
import java.util.Scanner;

public class ProductCategoryService implements IService<ProductCategory> {
    Scanner scanner = new Scanner(System.in);
    private static List<ProductCategory> productCategoryList = ReadWriteFileCategory.getInstance().readFile();

    @Override
    public void add() throws InterruptedException {
        System.out.println("_____Thêm Danh Mục Sản Phẩm_____");
        System.out.print("Nhập mã danh mục sản phẩm: ");
        int idCategory = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên danh mục sản phẩm: ");
        String nameCategory = scanner.nextLine();

        productCategoryList.add(new ProductCategory(idCategory, nameCategory));

        ReadWriteFileCategory.getInstance().writeFile(productCategoryList);
        System.out.println("Bạn đã thêm danh mục sản phẩm thành công.");
        System.out.println();
    }

    @Override
    public void edit() throws InterruptedException {
        System.out.println("_____Chỉnh Sửa Danh Mục Sản Phẩm_____");
        show();
        System.out.print("Nhập mã danh mục mà bạn muốn chỉnh sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ProductCategory categoryToEdit = null;
        for (ProductCategory category : productCategoryList) {
            if (category.getIdProductCategory() == id) {
                categoryToEdit = category;
                break;
            }
        }

        if (categoryToEdit == null) {
            System.out.println("Không tìm thấy Id cần chỉnh sửa trong danh sách danh mục sản phẩm.");
            System.out.println();
            return;
        }

        System.out.print("Nhập tên mới của danh mục sản phẩm: ");
        String newName = scanner.nextLine();

        categoryToEdit.setNameProductCategory(newName);

        ReadWriteFileCategory.getInstance().writeFile(productCategoryList);
        System.out.println("Đã chỉnh sửa danh mục sản phẩm thành công.");
        System.out.println();
    }

    @Override
    public void delete() throws InterruptedException {
        System.out.println("_____Xóa Danh Mục Sản Phẩm_____");
        show();
        System.out.print("Nhập mã danh mục mà bạn muốn xóa: ");
        int idDelete = scanner.nextInt();
        scanner.nextLine();
        boolean remove = false;

        for (int i = 0; i < productCategoryList.size(); i++) {
            if (productCategoryList.get(i).getIdProductCategory() == idDelete) {
                productCategoryList.remove(i);
                remove = true;
                break;
            }
        }

        if (remove) {
            ReadWriteFileCategory.getInstance().writeFile(productCategoryList);
            System.out.println("Đã xóa danh mục thành công.");
        } else {
            System.out.println("Không tìm thấy Id cần xóa trong danh sách danh mục sản phẩm.");
        }
        System.out.println();
    }

    @Override
    public void show() throws InterruptedException {
        System.out.printf("| %-5s | %-20s |%n", "ID", "NAME");
        System.out.println("________________________________");
        for (ProductCategory category : productCategoryList) {
            System.out.printf("| %-5s | %-20s |%n", category.getIdProductCategory(), category.getNameProductCategory());
        }
        System.out.println();
    }

    @Override
    public void findById() throws InterruptedException {
        System.out.println("_____Tìm kiếm danh mục sản phẩn theo mã danh mục ._____");
        System.out.print("Nhập mã danh mục cần tìm: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean find = false;
        for (ProductCategory category : productCategoryList) {
            if (category.getIdProductCategory() == id) {
                System.out.printf("| %-5s | %-20s |%n", "ID", "NAME");
                System.out.println("________________________________");
                System.out.printf("| %-5s | %-20s |%n", category.getIdProductCategory(), category.getNameProductCategory());
                find = true;
            }
        }

        if (!find) {
            System.out.print("Không tìm thấy danh mục sản phẩm có mã là " + id);
        }
        System.out.println();
    }

    @Override
    public void findByName() throws InterruptedException {
        System.out.println("_____Tìm kiếm danh mục sản phẩn theo tên danh mục._____");
        System.out.print("Nhập tên danh mục cần tìm: ");
        String name = scanner.nextLine();

        boolean find = false;
        for (ProductCategory category : productCategoryList) {
            if (category.getNameProductCategory().equalsIgnoreCase(name)) {
                System.out.printf("| %-5s | %-20s |%n", "ID", "NAME");
                System.out.println("________________________________");
                System.out.printf("| %-5s | %-20s |%n", category.getIdProductCategory(), category.getNameProductCategory());
                find = true;
            }
        }

        if (!find) {
            System.out.println("Không tìm thấy danh mục sản phẩm có tên là " + name);
        }
        System.out.println();
    }
}
