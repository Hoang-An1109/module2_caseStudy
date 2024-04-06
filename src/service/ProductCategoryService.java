package service;

import model.ProductCategory;
import storage.productCategoryStorage.IProductCategoryStorage;
import storage.productCategoryStorage.ReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class ProductCategoryService implements IService<ProductCategory> {
    Scanner scanner = new Scanner(System.in);
    private static IProductCategoryStorage iProductCategoryStorage = ReadWriteFile.getInstance();
    private static List<ProductCategory> productCategoryList = iProductCategoryStorage.readFile();

    @Override
    public void add() throws InterruptedException {
        System.out.println("_____Thêm Danh Mục Sản Phẩm_____");
        System.out.print("Nhập ID danh mục sản phẩm: ");
        int idCategory = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên danh mục sản phẩm: ");
        String nameCategory = scanner.nextLine();

        productCategoryList.add(new ProductCategory(idCategory, nameCategory));

        ReadWriteFile.getInstance().writeFile(productCategoryList);
        System.out.println("Bạn đã thêm danh mục sản phẩm thành công.");
    }

    @Override
    public void edit() throws InterruptedException {
        System.out.println("_____Chỉnh Sửa Danh Mục Sản Phẩm_____");
        System.out.print("Nhập Id mà bạn muốn chỉnh sửa: ");
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
            return;
        }

        System.out.print("Nhập tên mới của danh mục sản phẩm: ");
        String newName = scanner.nextLine();

        categoryToEdit.setNameProductCategory(newName);

        ReadWriteFile.getInstance().writeFile(productCategoryList);
        System.out.println("Đã chỉnh sửa danh mục sản phẩm thành công.");
    }

    @Override
    public void delete() throws InterruptedException {
        System.out.println("_____Xóa Danh Mục Sản Phẩm_____");
        System.out.print("Nhập Id mà bạn muốn xóa: ");
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
            ReadWriteFile.getInstance().writeFile(productCategoryList);
            System.out.println("Đã xóa thành công.");
        } else {
            System.out.println("Không tìm thấy Id cần xóa trong danh sách danh mục sản phẩm.");
        }
    }

    @Override
    public void show() throws InterruptedException {
        System.out.printf("| %-10s | %-40s |%n", "ID", "NAME");
        for (ProductCategory category : productCategoryList) {
            System.out.printf("| %-10s | %-40s |%n", category.getIdProductCategory(), category.getNameProductCategory());
        }
    }

    @Override
    public void findById() throws InterruptedException {

    }

    @Override
    public void findByName() throws InterruptedException {

    }
}
