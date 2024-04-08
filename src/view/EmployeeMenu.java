package view;

import controller.EmployeeController;
import controller.LoginController;

public class EmployeeMenu {
    public static void showEmployeeMenu() throws InterruptedException{
        System.out.println("__________"+ LoginController.showUsername() +"__________");
        System.out.println("1. Hiển thị danh sách sản phẩm.");
        System.out.println("2. Tìm kiếm sản phẩm theo mã sản phẩm.");
        System.out.println("3. Tìm kiếm sản phẩm theo tên sản phẩm.");
        System.out.println("4. Tìm kiếm sản phẩm theo danh mục sản phẩm.");
        System.out.println("5. Thêm sản phẩm vào giỏ hàng.");
        System.out.println("6. Xem giỏ hàng.");
        System.out.println("7. Thanh toán.");
        System.out.println("8. Xem hóa đơn.");
        System.out.println("0. Đăng xuất.");
        EmployeeController.controllerEmployee();
    }
}
