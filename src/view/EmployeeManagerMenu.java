package view;

import controller.EmployeeManagerController;

public class EmployeeManagerMenu {
    public static void showEmployeeManagerMenu() throws InterruptedException{
        System.out.println("__________Menu__________");
        System.out.println("1. Thêm nhân viên.");
        System.out.println("2. Xóa nhân viên.");
        System.out.println("3. Sửa thông tin nhân viên.");
        System.out.println("4. Hiển thị thông tin nhân viên.");
        System.out.println("5. Tìm kiếm nhân viên theo mã nhân viên.");
        System.out.println("6. Tìm kiếm nhân viên theo tên nhân viên.");
        System.out.println("0. Quay trở về menu quản lý.");
        EmployeeManagerController.controllerEmployeeManager();
    }
}
