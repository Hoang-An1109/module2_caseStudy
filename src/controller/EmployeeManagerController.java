package controller;

import service.EmployeeManagerService;
import view.EmployeeManagerMenu;
import view.ManagerMenu;

import java.util.Scanner;

public class EmployeeManagerController {
    public static void controllerEmployeeManager() throws InterruptedException{
        Scanner scanner=new Scanner(System.in);
        EmployeeManagerMenu employeeManagerMenu=new EmployeeManagerMenu();
        EmployeeManagerService employeeManagerService=new EmployeeManagerService();

        System.out.print("Mời bạn chon: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    employeeManagerService.add();
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 2:{ //Xóa nhân viên
                    employeeManagerService.delete();
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 3:{
                    employeeManagerService.edit();
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 4:{
                    employeeManagerService.show();
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 5:{  //Tìm kiếm theo mã
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 6:{ //Tìm kiếm theo tên
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 0:{
                    ManagerMenu.showMenuManager();
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
            }
        }
    }
}
