package management.studentManagement;

import java.util.Scanner;

public class StudentRecordMGMT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of students to manage
        System.out.println("Enter how many students you want to enter");
        int size = scanner.nextInt();
        scanner.nextLine();

        // Initialize the student record system with the specified size
        StudentRecordSystem system = new StudentRecordSystem(size);

        // Display menu options to the user
        System.out.println("What would you like to do?");
        System.out.println("1. Add Student");
        System.out.println("2. Search student");
        System.out.println("3. Display all students");
        System.out.println("4. Exit");

        while (true) {
            // Prompt for menu choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new student
                    if (system.studentCount >= system.students.length) {
                        // Check if the maximum number of students has been reached
                        System.out.println("Maximum students reached");
                    } else {
                        // Gather student details from the user
                        System.out.println("Enter student ID: ");
                        int sid = scanner.nextInt();
                        sid = system.validateIdAge(sid); // Validate student ID
                        scanner.nextLine(); // Consume newline character

                        System.out.println("Enter student name: ");
                        String name = scanner.nextLine();
                        name = system.validateString(name, "Name"); // Validate student name

                        System.out.println("Enter student department: ");
                        String dept = scanner.nextLine();
                        dept = system.validateString(dept, "Department"); // Validate student department

                        System.out.println("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        age = system.validateIdAge(age); // Validate student age

                        // Add the new student to the system
                        system.addStudent(new Student(sid, name, dept, age));
                    }
                    break;

                case 2:
                    // Search for a student by ID
                    System.out.println("Enter student id to search");
                    system.getStudent(scanner.nextInt());
                    break;

                case 3:
                    // Display all students in the system
                    system.displayAllStudents();
                    break;

                case 4:
                    // Exit the program
                    System.out.println("All operations performed successfully");
                    return;

                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
