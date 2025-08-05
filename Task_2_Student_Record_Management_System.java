
package intenshiptasks.pkg1;


import java.util.ArrayList;
import java.util.Scanner;
    
    
    
    

// Student class
class Student {
    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display student information
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class Task_2_Student_Record_Management_System {

    // List to store student records
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Add a student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student Data added successfully.");
    }

    // View all students
    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // Update student
    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.id == id) {
                scanner.nextLine(); // consume newline
                System.out.print("Enter new Name: ");
                s.name = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                s.marks = scanner.nextDouble();
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Delete student
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = studentList.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
    
