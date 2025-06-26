import java.io.*;
import java.util.*;

public class StudentManager{

    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addStudent(Scanner sc) throws IOException {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        FileWriter writer = new FileWriter(FILE_NAME, true);
        writer.write(id + "," + name + "\n");
        writer.close();

        System.out.println("Student added successfully!");
    }

    static void viewStudents() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No students found.");
            return;
        }

        Scanner reader = new Scanner(file);
        System.out.println("\nStudent List:");
        while (reader.hasNextLine()) {
            String[] data = reader.nextLine().split(",");
            System.out.println("ID: " + data[0] + " | Name: " + data[1]);
        }
        reader.close();
    }
}

