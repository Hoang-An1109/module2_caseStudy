import model.Product;
import model.ProductCategory;
import storage.ProductCategoryStorage.IProductCategoryStorage;
import storage.productStorage.IProductStorage;
import storage.productStorage.ReadWriteFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //    private static IProductCategoryStorage iProductCategoryStorage= ReadWriteFile.getInstance();
//    private static List<ProductCategory> list=iProductCategoryStorage.readFile();
    private static IProductStorage iProductStorage = ReadWriteFile.getInstance();
    private static List<Product> list = iProductStorage.readFile();

    public static void main(String[] args) {
//        List<Product> products = new ArrayList<>();
//        products.add(new Product(03, "Bạc Xỉu", "Cafe Việt", 15000, 8));
//        products.add(new Product(01, "Cafe Sữa", "Cafe Việt", 15000, 10));
//
//        String productFile = "product.csv";
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(productFile, true))) {
//                for(Product p: products){
//                    String[] productData={
//                            String.valueOf(p.getIdProduct()),p.getNameProduct(),p.getNameProductCategory(),String.valueOf(p.getPrice()),String.valueOf(p.getQuantity())
//                    };
//                    bufferedWriter.write(String.join(",",productData));
//                    bufferedWriter.newLine();
//            }
//            System.out.println("Đã ghi sản phẩm Product vào file CSV thành công.");
//        } catch(IOException e) {
//            throw new RuntimeException(e);
//        }

        for (Product product: list){
            System.out.println(product);
        }
//
//        String productCategoryFile = "productCategory.csv";
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(productCategoryFile, true))) {
//            for (ProductCategory productCategory : productCategoryList) {
//                String[] productCategoryData = {
//                        String.valueOf(productCategory.getIdProductCategory()),
//                        productCategory.getNameProductCategory()};
//                bufferedWriter.write(String.join(",", productCategoryData));
//                bufferedWriter.newLine();
//            }
//            System.out.println("Đã ghi danh mục sản phẩm ProductCategory vào file CSV thành công");
//        } catch (IOException e) {
//            System.out.println("Đã xảy ra lỗi khi ghi sản phẩm vào file CSV: " + e.getMessage());
//        }
//        for (ProductCategory productCategory: list){
//            System.out.println(productCategory);
//        }
//        System.out.println(list);
    }


}
