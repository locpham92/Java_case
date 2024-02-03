package validate;

import model.Product;
import model.Staff;
import model.Admin;

import java.util.List;
import java.util.Scanner;

public class ValidateStaff {
    static Scanner scanner = new Scanner(System.in);
    public static String vName(List<Staff> staffs, List<Admin> admins) {
        while (true) {
            boolean check=true;
            System.out.println("Input name: ");
            String name = scanner.nextLine();
            for (Staff s : staffs) {
                for (Admin a : admins)
                if (s.getUsername().equals(name) || a.getUsername().equals(name)) {
                    System.out.println("Duplicate!");
                    break;
                }
            }
            if (check) {
                return name;
            }
        }
    }
    public static int vDate() {
        while (true) {
            try {
                System.out.println("Input date: ");
                int date=scanner.nextInt();
                return date;
            } catch (Exception e) {
                scanner.nextLine();
                e.getStackTrace();
                System.out.println("Wrong!");
            }
        }
    }
    public static double vFactor() {
        while (true) {
            try {
                System.out.println("Input factor: ");
                double factor = scanner.nextInt();
                return factor;
            } catch (Exception e) {
                scanner.nextLine();
                e.printStackTrace();
                System.out.println("Wrong!");
            }
        }
    }
}
