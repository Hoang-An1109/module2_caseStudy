package service;

import model.Bill;
import model.Cart;
import model.Product;
import model.User;
import storage.billStorage.ReadWriteFileBill;
import storage.cartStorage.ReadWriteFileCart;
import storage.productStorage.ReadWriteFileProduct;
import storage.userStorage.ReadWriteFileUser;
import view.EmployeeMenu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    Scanner scanner = new Scanner(System.in);
    List<Cart> cartList = ReadWriteFileCart.getInstance().readFile();
    List<Product> productList = ReadWriteFileProduct.getInstance().readFile();
    List<User> userList= ReadWriteFileUser.getInstance().readFile();
    List<Bill> billList= ReadWriteFileBill.getInstance().readFile();

    public void addCart() throws InterruptedException {
        ProductService productService = new ProductService();
        productService.show();

        System.out.print("Nhập mã phẩm muốn mua: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exit = false;
        for (Product product : productList) {
            if (product.getId() == id) {
                exit = true;
                boolean checkQuantity = false;
                while (!checkQuantity) {
                    boolean overZero = false;
                    while (!overZero) {
                        System.out.print("Nhập số lượng: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        if (quantity > 0) {
                            overZero = true;
                            if (quantity <= product.getQuantity()) {
                                checkQuantity = true;
                                Cart cart = new Cart(id, product.getName(), quantity, product.getPrice());

                                cartList.add(cart);
                                ReadWriteFileCart.getInstance().writeFile(cartList);
                                System.out.println("Sản phẩm đã được thêm vào giỏ hàng.");
                                System.out.println();
                                showCart();

                                break;
                            } else {
                                System.out.println("Số lượng không được lớn hơn số lượng tồn.");
                            }
                        } else {
                            System.out.println("Số lương phải lơn hơn 0.");
                        }
                    }
                }
            }
        }
        if(!exit){
            System.out.println("Không tìm thấy mã sản phẩm bạn muốn mua.");
            addCart();
        }
    }

    public void showCart() {
        double total = 0;
        int count = 1;
        System.out.printf("| %-3s | %-30s | %-10s | %-8s | %-8s | %n", "ID", "NAME PRODUCT", "QUANTITY ", "PRICE", "TOTAL PRICE");
        System.out.println("_______________________________________________________________________________");
        for (Cart cart : cartList) {
            System.out.printf("| %-3s | %-30s | %-10s | %-8s | %-8s | %n", count++, cart.getNameProduct(), cart.getQuantity(), cart.getPrice(), cart.getTotalAmount());
            total += cart.getTotalAmount();
        }
        System.out.printf("Total: %.2f", total);
        System.out.println();
    }

    public List<Cart> getCartList(){
        List<Cart> carts=new ArrayList<>();
        for (Cart cart: cartList){
            Cart cartItem=new Cart(cart.getId(),cart.getNameProduct(),cart.getQuantity(),cart.getPrice());
            carts.add(cartItem);
        }
        return carts;
    }

    public void buyProduct() throws InterruptedException {
        User currentUser =null;
        for (User user:userList){
            if(user.getUserName().equalsIgnoreCase(LoginService.currentUser)){
                currentUser =user;
            }
        }
        boolean exit =false;
        if (getCartList().size()>0){
            exit=true;
        }

        if (exit){
            System.out.println("__________Cart Product__________");
            showCart();
            System.out.println("Bạn muốn thanh toán tất cả sản phẩm trong giỏ hàng ?");
            System.out.println("1. Có.");
            System.out.println("2. Không.");
            System.out.print("Mời bạn chọn: ");
            int option= scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:{
                    int id = billList.size() + 1;
                    String nameUser= currentUser.getUserName();
                    LocalDateTime localDateTime=LocalDateTime.now();
                    List<Cart> myCartList =getCartList();

                    Bill bill=new Bill(id,nameUser,localDateTime, myCartList);
                    billList.add(bill);
                    ReadWriteFileBill.getInstance().writeFile(billList);

                    ProductService.setProductList(cartList);
                    System.out.println("Bạn đã thanh toán thành công.");

                    myCartList.clear();
                    ReadWriteFileCart.getInstance().writeFile(myCartList);

                    break;
                }
                case 2:{
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
                default:{
                    System.out.println("Yêu cầu bạn chọn không có trong Menu.");
                    EmployeeMenu.showEmployeeMenu();
                    break;
                }
            }
        }else {
            System.out.println("Không có sản phẩm nào trong giỏ hàng.");
        }
        System.out.println();
    }
}
