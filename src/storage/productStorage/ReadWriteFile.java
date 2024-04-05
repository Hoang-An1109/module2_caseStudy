package storage.productStorage;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IProductStorage {
    private static ReadWriteFile instance1;
    private ReadWriteFile() {
    }
    public static ReadWriteFile getInstance() {
        if (instance1 ==null){
            synchronized (ReadWriteFile.class){
                if (instance1 == null)
                    instance1 = new ReadWriteFile();
            }
        }
        return instance1;
    }

    private static final File file=new File("product.csv");

    @Override
    public void writeFile(List<Product> product) {
        try {
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
//            StringBuilder productString=new StringBuilder();
            String line;
            for(Product p:product){
                line=p.getIdProduct()+","+p.getNameProduct()+","+p.getNameProductCategory()+","+p.getPrice()+","+p.getQuantity();
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> readFile() {
        List<Product> productList=new ArrayList<>();
        String line;
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while((line=bufferedReader.readLine())!=null){
                String[] productString=line.split(",");
                int idProduct=Integer.parseInt(productString[0]);
                String nameProduct=productString[1];
                String nameProductCategory=productString[2];
                double price=Double.parseDouble(productString[3]);
                int quantity=Integer.parseInt(productString[4]);

                Product product=new Product(idProduct,nameProduct,nameProductCategory,price,quantity);
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
