package controller;

import service.EmployeeService;
import service.ProductService;
import view.EmployeeMenu;
import view.LoginMenu;

import java.util.Scanner;

public class EmployeeController {
    public static void controllerEmployee() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        ProductService productService=new ProductService();

        System.out.print("Mời bạn chọn: ");
        int option = scanner.nextInt();

        boolean exit = true;
        while (exit) {
            switch (option) {
                case 1: {
                    productService.show();
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 2: {
                    productService.findById();
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 3: {
                    productService.findByName();
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 4: {
                    productService.findByCategory();
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 5: {
                    productService.findByPrice();
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 6: {
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 7: {
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 8: {
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 0: {
                    System.out.println();
                    LoginMenu.showMenuLogin();
                    break;
                }
                default: {
                    System.out.println("Yêu cầu bạn chọn không có trong Menu.");
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
            }
        }
    }
}
