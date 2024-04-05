package storage.productCategoryStorage;

import model.ProductCategory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IProductCategoryStorage{
    private static ReadWriteFile instance;
    private ReadWriteFile(){

    }
    public static ReadWriteFile getInstance() {
        if (instance==null){
            synchronized (ReadWriteFile.class){
                if (instance == null)
                    instance = new ReadWriteFile();
            }
        }
        return instance;
    }
    private static final File file = new File("productCategory.csv");

    public void writeFile(List<ProductCategory> productCategoryList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder categoryString = new StringBuilder();
            for (ProductCategory productCategory : productCategoryList) {
                categoryString.append(productCategory.getIdProductCategory()).append(",").append(productCategory.getNameProductCategory()).append("\n");
            }
            bufferedWriter.write(categoryString.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductCategory> readFile() {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] productCategoryString = line.split(",");
                if (productCategoryString.length != 2) {
                    continue;
                }
                int idCategory = Integer.parseInt(productCategoryString[0].trim()); // Chuyển đổi id thành số nguyên
                String nameCategory = productCategoryString[1].trim(); // Lấy tên danh mục
                ProductCategory productCategory = new ProductCategory(idCategory, nameCategory);
                productCategoryList.add(productCategory);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productCategoryList;
    }


}
