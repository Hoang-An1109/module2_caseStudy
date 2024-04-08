package controller;

import service.BillService;
import service.SortProductService;
import view.BillMenu;
import view.SortProductMenu;

import java.util.Scanner;

public class SortProductController {
    public static void controllerSortProduct() throws InterruptedException{
        Scanner scanner=new Scanner(System.in);
        SortProductService sortProductService=new SortProductService();

        System.out.print("Mời bạn chon: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    SortProductMenu.showSortProductMenu();
                    break;
                }
                case 2:{
                    SortProductMenu.showSortProductMenu();
                    break;
                }
                case 3:{
                    SortProductMenu.showSortProductMenu();
                    break;
                }
                case 4:{
                    SortProductMenu.showSortProductMenu();
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    SortProductMenu.showSortProductMenu();
                    break;
                }
            }
        }
    }
}
