package controller;

import service.ProductService;
import view.ProductMenu;

import java.util.Scanner;

public class ProductController {
    public static void controllerProduct() throws InterruptedException{
        Scanner scanner=new Scanner(System.in);
        ProductService productService=new ProductService();

        System.out.print("Mời bạn chọn: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    productService.add();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 2:{
                    productService.edit();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 3:{
                    productService.delete();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 4:{
                    productService.show();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 5:{

                }
                case 6:{

                }
                case 7:{

                }
                case 0:{

                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ProductMenu.showMenuProduct();
                    break;
                }
            }
        }
    }
}
