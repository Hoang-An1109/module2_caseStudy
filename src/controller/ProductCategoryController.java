package controller;

import service.ProductCategoryService;
import view.EmployeeManagerMenu;
import view.ManagerMenu;
import view.ProductCategoryMenu;

import java.util.Scanner;

public class ProductCategoryController {
    public static void controllerProductCategory() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ProductCategoryService productCategoryService = new ProductCategoryService();

        System.out.print("Mời bạn chọn: ");
        int option = scanner.nextInt();
        System.out.println();

        boolean exit = true;
        while (exit) {
            switch (option) {
                case 1: {
                    productCategoryService.add();
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 2: {
                    productCategoryService.edit();
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 3: {
                    productCategoryService.delete();
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 4: {
                    productCategoryService.show();
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 5: {
                    productCategoryService.findById();
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 6: {
                    productCategoryService.findByName();
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 0: {
                    ManagerMenu.showMenuManager();
                    break;
                }
                default: {
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ProductCategoryMenu.showMenuCategory();
                    break;
                }
            }
        }
    }
}
