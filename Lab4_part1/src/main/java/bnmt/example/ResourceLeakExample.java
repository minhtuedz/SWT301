package bnmt.example;

import java.io.*;

public class ResourceLeakExample {
    public static void main(String[] args) {
        File file = new File("data.txt");

        if (!file.exists()) {
            System.err.println("Error: File not found: " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
