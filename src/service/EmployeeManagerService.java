package service;

import model.User;
import storage.userStorage.ReadWriteFileUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagerService {
    Scanner scanner = new Scanner(System.in);
    List<User> userList = ReadWriteFileUser.getInstance().readFile();

    public void add() throws InterruptedException {
        System.out.println("__________Thêm nhân viên__________");
        System.out.print("Nhập mã nhân viên: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean usernameExists = false;
        String userName;
        String USERNAME_REGEX = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
        do {
            System.out.print("Nhập username: ");
            userName = scanner.nextLine();

            if (userName.matches(USERNAME_REGEX)) {
                for (User user : userList) {
                    if (user.getUserName().equals(userName)) {
                        System.out.println("Username đã có người dùng. Xin vui lòng nhập lại.");
                        usernameExists = false;
                        break;
                    }else {
                        usernameExists=true;
                        break;
                    }
                }
            } else {
                System.out.println("Username không hợp lệ. Xin vui lòng nhập lại.");
                System.out.println("\033[34m" + "Tên người dùng phải có ít nhất 6 ký tự, bao gồm ít nhất 1 chữ số và 1 chữ in hoa." + "\033[0m");
            }

        } while (!usernameExists);

        String password;
        boolean isExcept = false;
        do {
            System.out.print("Nhập mật khẩu: ");
            password = scanner.nextLine();

            String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
            if (password.matches(PASSWORD_REGEX)) {
                isExcept = true;
            } else {
                System.err.println("Mật khẩu không hợp lệ.  Xin vui lòng nhập lại.");
                System.out.println("\033[34m" + "Mật khẩu phải có ít nhất 6 ký tự, trong đó có ít nhất 1 chữ số và 1 chữ in hoa." + "\033[0m");
            }
        } while (!isExcept);

        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd-MM-yyyy): ");
        String dateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        String role = "Employee";

        String phone;
        boolean isValid = false;
        do {
            String PHONE_REGEX = "^0\\d{9,}$";
            System.out.print("Nhập số điện thoại phải có ít nhất 10 số và bắt đầu bằng 0: ");
            phone = scanner.nextLine();

            String phoneString = String.valueOf(phone);

            if (phone.matches(PHONE_REGEX)) {
                isValid = true;
            } else {
                System.err.println("Số điện thoại không hợp lệ.");
            }
        } while (!isValid);

        User newUser = new User(id, userName, password, fullName, gender, date, role, phone);
        userList.add(newUser);

        ReadWriteFileUser.getInstance().writeFile(userList);
        System.out.println("Thêm thành viên thành công.");
    }

    public void edit() throws InterruptedException {
        System.out.println("__________Sửa thông tin nhân viên__________");
        System.out.println("Nhập mã nhân viên cần sửa: ");
        int idEdit = scanner.nextInt();
        scanner.nextLine();

        User userToEdit = null;
        for (User user : userList) {
            if (user.getId() == idEdit) {
                userToEdit = user;
                break;
            }
        }

        if (userToEdit == null) {
            System.out.println("Không tìm thấy mã nhân viên cần chỉnh sửa trong danh sách.");
            return;
        }

        boolean usernameExists = false;
        String userName;
        String USERNAME_REGEX = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
        do {
            System.out.print("Nhập username: ");
            userName = scanner.nextLine();

            if (userName.matches(USERNAME_REGEX)) {
                for (User user : userList) {
                    if (user.getUserName().equals(userName)) {
                        System.out.println("Username đã có người dùng. Xin vui lòng nhập lại.");
                        usernameExists = false;
                        break;
                    }else {
                        usernameExists=true;
                        break;
                    }
                }
            } else {
                System.out.println("Username không hợp lệ. Xin vui lòng nhập lại.");
                System.out.println("\033[34m" + "Tên người dùng phải có ít nhất 6 ký tự, bao gồm ít nhất 1 chữ số và 1 chữ in hoa." + "\033[0m");
            }

        } while (!usernameExists);

        String password;
        boolean isExcept = false;
        do {
            System.out.print("Nhập mật khẩu: ");
            password = scanner.nextLine();

            String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
            if (password.matches(PASSWORD_REGEX)) {
                isExcept = true;
            } else {
                System.err.println("Mật khẩu không hợp lệ.  Xin vui lòng nhập lại.");
                System.out.println("\033[34m" + "Mật khẩu phải có ít nhất 6 ký tự, trong đó có ít nhất 1 chữ số và 1 chữ in hoa." + "\033[0m");
            }
        } while (!isExcept);

        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd-MM-yyyy): ");
        String dateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        String role = "Employee";

        String phone;
        boolean isValid = false;
        do {
            String PHONE_REGEX = "^0\\d{9,}$";
            System.out.print("Nhập số điện thoại phải có ít nhất 10 số và bắt đầu bằng 0: ");
            phone = scanner.nextLine();

            String phoneString = String.valueOf(phone);

            if (phone.matches(PHONE_REGEX)) {
                isValid = true;
            } else {
                System.err.println("Số điện thoại không hợp lệ.");
            }
        } while (!isValid);

        userToEdit.setUserName(userName);
        userToEdit.setPassword(password);
        userToEdit.setFullName(fullName);
        userToEdit.setGender(gender);
        userToEdit.setDateOfBirth(date);
        userToEdit.setRole(role);
        userToEdit.setPhoneNumber(phone);

        ReadWriteFileUser.getInstance().writeFile(userList);
        System.out.println("Đã chỉnh sửa thông tin thành viên thành công.");
        System.out.println();

    }

    public void show() throws InterruptedException{
        System.out.printf("| %-10s | %-40s | %-40s | %-20s | %-20s | %-20s | %-20s | %-20s | %n", "ID", "USERNAME", "PASSWORD", "HỌ VÀ TÊN", "GIỚI TÍNH","NGÀY SINH","CHỨC VỤ","SỐ ĐIỆN THOẠI");
        System.out.println("___________________________________________________________________________");
        for (User user: userList){
            System.out.printf("| %-10s | %-40s | %-40s | %-20s | %-20s | %-20s | %-20s | %-20s | %n",user.getId(),user.getUserName(),user.getPassword(),user.getFullName(),user.getGender(),user.getDateOfBirth(),user.getRole(),user.getPhoneNumber());
        }
        System.out.println();
    }

    public void delete() throws InterruptedException{
        System.out.println("__________Xóa Nhân Viên__________");
        System.out.println("Nhập mã nhân viên mà bạn muốn xóa: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        boolean remove=false;
        for (int i=0;i<userList.size();i++){
            if (userList.get(i).getId()==id){
                userList.remove(i);
                remove=true;
                break;
            }
        }

        if (remove){
            ReadWriteFileUser.getInstance().writeFile(userList);
            System.out.println("Đã xóa nhân viên thành công.");
        }else {
            System.out.println("Không tìm thấy mã nhân viên cần xóa trong danh sách nhân viên.");
        }
        System.out.println();
    }



}
