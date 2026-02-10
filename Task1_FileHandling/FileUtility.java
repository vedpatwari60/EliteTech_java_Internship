import java.io.*;
 class FileUtility {

    public static void main(String[] args) {
        String fileName = "records.txt";

        System.out.println("===== FILE HANDLING UTILITY V2 =====\n");

        writeFile(fileName);
        readFile(fileName);
        appendFile(fileName);
    }

    private static void writeFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Employee: VEDANTTT\n");
            writer.write("Department: ENTC\n");
            writer.write("Status: File Created Successfully\n");
            System.out.println("1. File created and written.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    private static void readFile(String fileName) {
        System.out.println("\n2. Reading file content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(">> " + line); // Added prefix for clarity
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void appendFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Status: File Updated with New Entry\n");
            writer.write("Timestamp: " + System.currentTimeMillis() + "\n"); // Added timestamp
            System.out.println("\n3. File updated successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
