package storage.ProductCategoryStorage;

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
            String line;
            for (ProductCategory productCategory : productCategoryList) {
                line=productCategory.getIdProductCategory()+","+ productCategory.getIdProductCategory();
                bufferedWriter.write(line);
            }
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
                String[] productCategoryString=line.split(",");
                int idCategory=Integer.parseInt(productCategoryString[0]);
                String nameCategory=productCategoryString[1];
                ProductCategory productCategory=new ProductCategory(idCategory,nameCategory);
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
