package menu;

import manage.ManageStaff;

import java.util.Scanner;
import model.Staff;
import model.Admin;

public class MenuHome {
    static Scanner scanner = new Scanner(System.in);
    static ManageStaff manageStaff =new ManageStaff();
    static MenuProduct menuProduct = new MenuProduct();
    public static int choice(){
        while (true){
            try {
                System.out.println("Please choose a function: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Please input number");
            }
        }
    }
    public void login() {
        while (true) {
            System.out.println("Please choose a function");
            System.out.println("1. Login admin");
            System.out.println("2. Login staff");
            System.out.println("3. Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    menuLoginAdmin();
                    break;
                case 2:
                    menuLoginStaff();
                case 3:
                    return;
            }

        }
    }

    public static void menuLoginAdmin() {
        manageStaff.readAdmin();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (manageStaff.checkAdmin(username, password)) {
            menuAdmin();
        } else {
            System.out.println("Please re-enter");
        }
    }
    public static void menuLoginStaff() {
        manageStaff.readStaff();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (manageStaff.checkStaff(username, password)) {
            menuProduct.menuSales();
        } else {
            System.out.println("Please re-enter");
        }
    }
    public static void menuAdmin() {
        while (true) {
            System.out.println("1. Staff Management");
            System.out.println("2. Product Management");
            System.out.println("3. Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    menuAdminStaff();
                    break;
                case 2:
                    menuProduct.menuAdminProduct();
                    break;
                case 3:
                    return;

            }
        }
    }
    public static void menuAdminStaff() {
        while (true) {
            System.out.println("Staff Management");
            System.out.println("1. Display all staff");
            System.out.println("2. Add a new staff");
            System.out.println("3. Salary");
            System.out.println("4. Edit the staff");
            System.out.println("5. Delete the staff");
            System.out.println("6. Read the file");
            System.out.println("7. Write to file");
            System.out.println("8. Creat an admin staff");
            System.out.println("9. Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    manageStaff.displayAll();
                    break;
                case 2:
                    menuAddStaff();
                    break;
                case 3:
                    menuSalaryStaff();
                    break;
                case 4:
                    menuEditStaff();
                    break;
                case 5:
                    menuDeleteStaff();
                    break;
                case 6:
                    manageStaff.readStaff();
                    break;
                case 7:
                    manageStaff.writeStaff();
                    break;
                case 8:
                    return;
            }

        }
    }
    public static void menuAddStaff() {
        while (true) {
            System.out.println("1. FullTime Staff");
            System.out.println("2. PartTime Staff");
            System.out.println("3. Return");
            int choice = choice();
            switch (choice) {
                case 1:
                    Staff fullTime = manageStaff.createStaff(true);
                    manageStaff.addStaff(fullTime);
                    break;
                case 2:
                    Staff partTime = manageStaff.createStaff(false);
                    manageStaff.addStaff(partTime);
                    break;
                case 3:
                    return;
            }
        }
    }
    public static void menuEditStaff() {
        System.out.println("Input name");
        String nameEdit = scanner.nextLine();
        int index = manageStaff.findIndexByName(nameEdit);
        Staff staff = manageStaff.createStaff(true);
        manageStaff.editStaff(index, staff);
    }
    public static void menuDeleteStaff() {
        System.out.println("Input name");
        String nameDelete = scanner.nextLine();
        manageStaff.deleteStaff(manageStaff.findIndexByName(nameDelete));

    }

    public static void menuSalaryStaff() {
        while (true) {
            System.out.println("1. FullTime Staff");
            System.out.println("2. PartTimeStaff");
            System.out.println("3. Return");
            int choice = choice();
            switch (choice) {
                case 1:
                    manageStaff.salaryFull();
                    break;
                case 2:
                    manageStaff.salaryPart();
                    break;
                case 3:
                    return;
            }
        }
    }


}
