package view;

import controller.ProductCategoryController;

import java.util.Scanner;

public class ProductCategoryView {
    public static Scanner scanner=new Scanner(System.in);
    public static void showMenuCategory() throws InterruptedException{
        System.out.println("__________Menu__________");
        System.out.println("1. Thêm danh mục sản phẩm.");
        System.out.println("2. Sửa danh mục sản phâm.");
        System.out.println("3. Xóa danh mục sản phẩm.");
        System.out.println("4. Hiển thị danh mục sản phẩm.");
        System.out.println("5. Tìm kiếm danh mục sản phẩm theo mã sản phẩm.");
        System.out.println("6. Tìm kiếm danh mục sản phẩm theo tên sản phẩm.");
        System.out.println("7. Thoát Menu");
        ProductCategoryController.controllerProductCategory();
    }
}
