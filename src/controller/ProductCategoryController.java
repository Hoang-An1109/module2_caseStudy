package controller;

import service.ProductCategoryService;
import view.ProductCategoryView;

import java.util.Scanner;

public class ProductCategoryController {
    public static void controllerProductCategory() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        ProductCategoryService productCategoryService= new ProductCategoryService();

        System.out.print("Mời bạn chon: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    productCategoryService.add();
                    ProductCategoryView.showMenuCategory();
                    break;
                }
                case 2:{
                    productCategoryService.edit();
                    ProductCategoryView.showMenuCategory();
                    break;
                }
                case 3:{
                    productCategoryService.delete();
                    ProductCategoryView.showMenuCategory();
                    break;
                }
                case 4:{
                    productCategoryService.show();
                    ProductCategoryView.showMenuCategory();
                    break;
                }
                case 5:{

                }
                case 6:{

                }
                case 7:{
                    exit=false;
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ProductCategoryView.showMenuCategory();
                    break;
                }

            }


        }
    }
}
