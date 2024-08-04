package management.gradeManagement;

import management.studentManagement.Student;
import management.courseManagement.Course;
import management.courseManagement.courseEnrollment;
import management.courseManagement.enrollment;
import management.studentManagement.StudentRecordSystem;

import java.util.Scanner;

public class gradingSystemMGMNT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize course catalog and course credits
        Course[] courseCatalog = courseEnrollment.courseCatalog;
        int[] courseCredits = new int[courseCatalog.length];

        // Prompt user for the number of students
        System.out.println("Enter the number of students to add:");
        int studentCount = scanner.nextInt();
        scanner.nextLine();

        // Initialize arrays for students and grading system
        Student[] students = new Student[studentCount];
        StudentRecordSystem studentSystem = new StudentRecordSystem(studentCount);
        gradingSystem gradingSystem = new gradingSystem(students, courseCredits);

        // Set course credits from course catalog
        for (int i = 0; i < courseCatalog.length; i++) {
            courseCredits[i] = courseCatalog[i].getCredits();
        }

        // Display menu options
        int count = 0;
        System.out.println("\nMenu:");
        System.out.println("1. Add Student");
        System.out.println("2. Add Grade");
        System.out.println("3. Add Course Credits");
        System.out.println("4. Calculate GPA");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new student
                    if (count < students.length) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Department: ");
                        String department = scanner.nextLine();
                        System.out.println("Enter age: ");
                        int age = scanner.nextInt();
                        Student student = new Student(id, name, department, age);
                        students[count] = student; // Add student to array
                        studentSystem.addStudent(student); // Add student to the record system
                        System.out.println("Student added successfully.");
                        count++; // Increment student count
                    } else {
                        System.out.println("Student array is full.");
                    }
                    break;

                case 2:
                    // Add a grade for a student
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    int courseID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade (A, B, C, D, F): ");
                    char gradeValue = scanner.next().charAt(0);
                    scanner.nextLine();
                    Student student = studentSystem.getStudentById(studentID);
                    Course course = enrollment.findCourseById(courseCatalog, courseID);
                    if (student != null && course != null) {
                        gradingSystem.addGrade(new Grade(student, course, gradeValue));
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Invalid student ID or course ID.");
                    }
                    break;

                case 3:
                    // Update course credits
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();
                    gradingSystem.addCourseCredits(courseId, credits);
                    System.out.println("Course credits updated successfully.");
                    break;

                case 4:
                    // Calculate GPA for a student
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    double gpa = gradingSystem.calculateGPA(studentId);
                    System.out.println("GPA for Student ID " + studentId + ": " + gpa);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    return;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
