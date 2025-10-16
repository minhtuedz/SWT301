package bnmt.example;
import java.io.*;


public class PathTraversalExample {
    public static void main(String[] args) {
        String userInput = "../secret.txt"; // Giả lập dữ liệu đầu vào
        File baseDir = new File("C:/safe_directory"); // Thư mục gốc được phép truy cập

        try {
            File file = new File(baseDir, userInput);
            String canonicalBase = baseDir.getCanonicalPath();
            String canonicalFile = file.getCanonicalPath();


            if (!canonicalFile.startsWith(canonicalBase)) {
                System.err.println("Error: Unauthorized file access detected!");
                return;
            }


            if (file.exists() && file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    System.out.println("Reading file safely: " + file.getName());
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            } else {
                System.out.println("File not found or invalid.");
            }
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
