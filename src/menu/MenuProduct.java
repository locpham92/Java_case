package menu;
import manage.ManageProduct;
import manage.ManageStaff;
import java.util.Scanner;
public class MenuProduct {
    static Scanner scanner =new Scanner(System.in);
    static ManageProduct manageProduct=new ManageProduct();
    static ManageStaff manageStaff=new ManageStaff();

    public static int choice(){
        while (true){
            try {
                System.out.println("Please choose a function: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Please input a number");
            }
        }
    }

    public static void menuAdminProduct() {
        while (true) {
            System.out.println("Product Management");
            System.out.println("1. Display all products");
            System.out.println("2. Add");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. Sort");
            System.out.println("6. Find the max price product");
            System.out.println("7. Read from file");
            System.out.println("8. Write the file");
            System.out.println("9. Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    manageProduct.display();
                    break;
                case 2:
                    manageProduct.add(manageProduct.create());
                    break;
                case 3:
                    manageProduct.edit();
                    break;
                case 4:
                    manageProduct.delete();
                    break;
                case 5:
                    menuSort();
                    break;
                case 6:
                    manageProduct.findProductMaxPrice();
                    break;
                case 7:
                    manageProduct.read();
                    break;
                case 8:
                    manageProduct.write();
                    break;
                case 9:
                    return;
            }
        }

    }
    public static void menuSort() {
        while (true) {
            System.out.println("Do you want to sort by price ascending or descending");
            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            System.out.println("3. Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    manageProduct.sortAscending();
                    break;
                case 2:
                    manageProduct.sortDescending();
                    break;
                case 3:
                    return;
            }
        }
    }
    public static void menuSales() {
        while (true) {
            System.out.println("Product Management");
            System.out.println("1. Display all products");
            System.out.println("2. Find the max price product");
            System.out.println("3. Read from product file");
            System.out.println("4. Write the product file");
            System.out.println("5. Timekeeping");
            System.out.println("6. Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    manageProduct.display();
                    break;
                case 2:
                    manageProduct.findProductMaxPrice();
                    break;
                case 3:
                    manageProduct.read();
                    break;
                case 4:
                    manageProduct.write();
                    break;
                case 5:
                    menuTimekeeping();
                    break;
                case 6:
                    return;
            }
        }
    }
    public static void menuTimekeeping() {
        manageStaff.timekeeping();
    }
}
