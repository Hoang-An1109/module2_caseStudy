package controller;

import service.EmployeeManagerService;
import view.EmployeeManagerMenu;

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
                case 1:{//Thêm nhân viên
                    employeeManagerService.add();
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 2:{ //Xóa nhân viên
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 3:{ //Sửa nhân viên
                    employeeManagerService.edit();
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 4:{  //Tìm kiếm theo mã
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 5:{ //Tìm kiếm theo tên
                    employeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 0:{ //Thoát
                    EmployeeManagerMenu.showEmployeeManagerMenu();
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
