package io;
import model.Staff;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class StaffIO {
    public static void readStaff(ArrayList<Staff> staffs) {
        try {
            File file = new File("staffs.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                Staff staff = new Staff(Integer.parseInt(arr[0]), arr[1], arr[2]);
                staffs.add(staff);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
    }

    public static void writeStaff(ArrayList<Staff> staffs) {
        try {
            File file = new File("staffs.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Staff staff : staffs) {
                bufferedWriter.write(staff.getId() + "," + staff.getUsername() + "," + staff.getPassword());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error write file");
        }
    }
}
