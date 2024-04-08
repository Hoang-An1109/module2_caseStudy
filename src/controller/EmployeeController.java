package controller;

import service.EmployeeService;
import view.EmployeeMenu;

import java.util.Scanner;

public class EmployeeController {
    public static void controllerEmployee() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        System.out.println("Mời bạn chọn: ");
        int option = scanner.nextInt();

        boolean exit = true;
        while (exit) {
            switch (option) {
                case 1: { //Hiên thị san phẩm
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 2: { //Tìm kiếm theo mã sản phẩm
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 3: { //tìm kiếm theo tên sản phẩm
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 4: { //Tìm kiếm theo danh mục
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 5: { //Thêm vào giwor hàng
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 6: { //Xem giỏ hàng
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 7: { //Thanh toán
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 8: { //Xem hóa đơn
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                case 0: {

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
