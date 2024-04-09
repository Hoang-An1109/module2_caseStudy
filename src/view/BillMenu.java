package view;

import controller.BillController;

public class BillMenu {
    public static void showMenuBill() throws InterruptedException{
        System.out.println("__________Menu__________");
        System.out.println("1. Hiển thị hóa đơn.");
        System.out.println("2. Tìm kiếm hóa đơn theo mã hóa đơn.");
        System.out.println("3. Tìm kiếm hóa đơn theo tên sản phẩm.");
        System.out.println("4. Tìm kiếm hóa đơn theo tên danh mục.");
        System.out.println("5. Xóa hóa đơn.");
        System.out.println("0. Quay trở về menu quản lý.");
        BillController.controllerBill();
    }
}
