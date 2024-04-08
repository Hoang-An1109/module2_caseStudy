package controller;

import view.ManagerMenu;
import view.ProductMenu;

import java.util.Scanner;

public class ManagerController {
    public static void controllerManager() throws InterruptedException{
        Scanner scanner=new Scanner(System.in);

        System.out.print("Mời bạn chọn: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    ManagerMenu.showMenuManager();
                    break;
                }
                case 2:{
                    ManagerMenu.showMenuManager();
                    break;
                }
                case 3:{
                    ManagerMenu.showMenuManager();
                    break;
                }
                case 4:{
                    ManagerMenu.showMenuManager();
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ManagerMenu.showMenuManager();
                    break;
                }
            }
        }
    }

}
