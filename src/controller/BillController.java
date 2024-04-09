package controller;

import service.BillService;
import view.BillMenu;
import view.ManagerMenu;
import view.ProductCategoryMenu;

import java.util.Scanner;

public class BillController {
    public static void controllerBill() throws InterruptedException{
        Scanner scanner=new Scanner(System.in);
        BillService billService=new BillService();

        System.out.print("Mời bạn chon: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{ //Hiển thị hóa đơn
                    BillMenu.showMenuBill();
                    break;
                }
                case 2:{ //Tìm kiếm theo mã
                    BillMenu.showMenuBill();
                    break;
                }
                case 3:{ //Tìm kiếm theo tên
                    BillMenu.showMenuBill();
                    break;
                }
                case 4:{ //Tìm kiếm theo danh mục
                    BillMenu.showMenuBill();
                    break;
                }
                case 5:{ //Xóa hóa đơn
                    BillMenu.showMenuBill();
                    break;
                }
                case 0:{
                    ManagerMenu.showMenuManager();
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    BillMenu.showMenuBill();
                    break;
                }
            }
        }
    }
}
