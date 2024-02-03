package manage;

import io.ProductIO;
import model.Product;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProduct {
    ValidateProduct validateProduct=new ValidateProduct();
    ArrayList<Product> products=new ArrayList<Product>();
    Scanner scanner=new Scanner(System.in);
    public void add(Product p) {
        products.add(p);
    }
    public void read() {
        ProductIO.readProduct();
    }
    public void write() {
        ProductIO.writeProduct(products);
    }
    public int findIndexByName(String name) {
        for (int i=0; i<products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public void display() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
    public void edit() {
        while (true) {
            System.out.println("Input the product name: ");
            String name = scanner.nextLine();
            if (findIndexByName(name) != -1) {
                String newName = ValidateProduct.vName(products);
                Double newPrice = ValidateProduct.vPrice();
                int newQuantity = ValidateProduct.vQuantity();
                String newContent = scanner.nextLine();

                products.set(findIndexByName(name), new Product(products.get(findIndexByName(name)).getId(), newName, newPrice, newQuantity, newContent));
                break;
            } else {
                System.out.println("Product with this name do not exist");
                scanner.nextLine();
            }
        }
        display();
        ProductIO.writeProduct(products);
    }
    public void delete() {
        while (true) {
            System.out.println("Input the product name: ");
            String name = scanner.nextLine();
            if (findIndexByName(name) != -1) {
                System.out.print("Warning: Would you like to remove this product?");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    products.remove(findIndexByName(name));
                    ProductIO.writeProduct(products);
                    display();
                    return;
                } else {
                    return;
                }
            } else {
                System.out.println("Product with this name do not exist");
                scanner.nextLine();
            }
        }

    }
    public void sortAscending() {
        for (int i = 0; i < products.size()-1; i++) {
            for (int j =i+1;j<products.size();j++) {
                if (products.get(i).getPrice() < products.get(j).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
        display();
    }
    public void sortDescending() {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getPrice() > products.get(j).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
        display();
    }
    public String findProductMaxPrice() {
        double maxPrice =-1;
        for (Product p : products) {
            if (p.getPrice() > maxPrice) {
                maxPrice = p.getPrice();
            }
        }
        for (Product p: products) {
            if (p.getPrice() == maxPrice) {
                return p.toString();
            }
        }
        return null;
    }
    public Product create() {
        String name = ValidateProduct.vName(products);
        Double price = ValidateProduct.vPrice();
        int quantity = ValidateProduct.vQuantity();
        System.out.println("Input content: ");
        String content = scanner.nextLine();
        int idEnd = 0;
        try {
            idEnd = products.get(products.size() - 1).getId();
        } catch (Exception e) {

        }
        return new Product(idEnd + 1, name, price, quantity, content);
    }
    public String inputName(String name) {
    System.out.println("Input name: ");
    return scanner.nextLine();
    }
    public void displayAllProducts() {

    }
    public void createOrder() {

    }
    public void displayALlProducts() {

    }
    public void profit() {

    }
}
