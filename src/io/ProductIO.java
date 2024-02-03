package io;
import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductIO {
    static File file=new File("products.csv");
    public static void writeProduct(List<Product> products) {
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Product p : products) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Product> readProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str="";
            while ((str = bufferedReader.readLine())!=null) {
               String[] arr=str.split(",");
               Product product = new Product(
                       Integer.parseInt(arr[0]),
                       arr[1],
                       Double.parseDouble(arr[2]),
                       Integer.parseInt(arr[3]),
                       arr[4]
               );
               products.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
