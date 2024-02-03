package manage;

import io.StaffIO;
import io.AdminIO;
import model.*;
import validate.ValidateStaff;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManageStaff {
    ArrayList<Staff> staffs = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void displayAll() {
        for (Staff s : staffs) {
            System.out.println(s.toString());
        }
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
        StaffIO.writeStaff(staffs);
    }
    public void addAdmin(Admin admin) {
        admins.add(admin);
        AdminIO.writeAdmin(admins);
    }
    public void readStaff() {
        StaffIO.readStaff(staffs);
    }
    public void writeStaff() {
        StaffIO.writeStaff(staffs);
    }
    public void readAdmin() {
        AdminIO.readAdmin(admins);
    }
    public void writeAdmin() {
        AdminIO.writeAdmin(admins);
    }

    public void editStaff(int index, Staff staff) {
        staff.setId(staffs.get(index).getId());
        staffs.set(index, staff);
    }

    public void deleteStaff(int index) {
        staffs.remove(index);
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getUsername().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public boolean checkUsername(String username) {
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password) {
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkStaff(String username, String password) {
        readAdmin();
        for (int i = 0; i < staffs.size(); i++) {
            if (checkUsername(username) && checkPassword(password)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkAdmin(String username, String password) {
        readAdmin();
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getUsername().equals(username) && admins.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public String validateUsername() {
        while (true) {
            System.out.println("Username: ");
            String username = scanner.nextLine();
            if (checkUsername(username)) {
                System.err.println("Duplicate!");
            } else {
                return username;
            }
        }
    }
    public String validatePassword() {
        while (true) {
            System.out.println("Password: ");
            String password = scanner.nextLine();
            System.out.println("Re-enter Password: ");
            String rePassword = scanner.nextLine();
            if (password.equals(rePassword)) {
                return password;
            } else {
                System.err.println("Wrong password. Please re-enter");
            }
        }
    }
    public Admin createAdmin() {
        System.out.println("Input username:");
        String username = scanner.nextLine();
        System.out.println("Input password:");
        String password = scanner.nextLine();
        int idEnd = 0;
        try {
            idEnd = admins.get(admins.size() - 1).getId();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new Admin(idEnd + 1, username, password);

    }
    public Staff createStaff(boolean isFullTime) {

        if (isFullTime) {
            String username = validateUsername();
            String password = validatePassword();
            int date = ValidateStaff.vDate();
            double factor = ValidateStaff.vFactor();
            int idEnd = 0;
            try {
                idEnd = staffs.get(staffs.size() - 1).getId();
            } catch (Exception e) {
            }
            return new FullTime(idEnd + 1,username,password,date,factor);
        } else {
            String username = validateUsername();
            String password = validatePassword();
            int date = ValidateStaff.vDate();
            double factor = ValidateStaff.vFactor();

            int idEnd = 0;
            try {
                idEnd = staffs.get(staffs.size() - 1).getId();
            } catch (Exception e) {
            }
            return new PartTime(idEnd + 1,username,password,date,factor);
        }
    }

    public void salaryFull() {
        for (Staff s : staffs) {
            if (s instanceof FullTime) {
                System.out.println(s.salary());
            }
        }
    }
    public void salaryPart() {
        for (Staff s : staffs) {
            if (s instanceof PartTime) {
                System.out.println(s.salary());
            }
        }
    }

    public void timekeeping() {
        System.out.println("Input name:");
        String name = scanner.nextLine();

        LocalDate today=LocalDate.now();
        LocalDate[] workDay=new LocalDate[staffs.size()];
        for (int i = 0; i <staffs.size(); i++) {
            if (staffs.get(i).getUsername().equals(name) && !todayChecked(workDay)) workDay[i+1]=today;
        }

        int[] timekeeping = new int[staffs.size()];
        for (int i = 0; i <staffs.size(); i++) {
            if (staffs.get(i).getUsername().equals(name) && !todayChecked(workDay)) timekeeping[i+1]+=1;
        }
    }
    public boolean todayChecked(LocalDate[] workDay) {
        LocalDate today = LocalDate.now();
        for (int i = 0; i < workDay.length; i++) {
            if (workDay[i].isEqual(today)) {
                System.out.println("You clocked in today!");
                return true;
            }
        }
        return false;
    }
}
