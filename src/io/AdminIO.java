package io;

import model.Staff;
import model.Admin;
import java.io.*;
import java.util.ArrayList;

public class AdminIO {
    public static void readAdmin(ArrayList<Admin> admins) {
        try {
            File file = new File("admin.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                Admin admin = new Admin(Integer.parseInt(arr[0]), arr[1], arr[2]);
                admins.add(admin);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
    }
    public static void writeAdmin(ArrayList<Admin> admins) {
        try {
            File file = new File("admin.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Admin admin : admins) {
                bufferedWriter.write(admin.getId() + "," + admin.getUsername() + "," + admin.getPassword());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error write file");
        }
    }
}
