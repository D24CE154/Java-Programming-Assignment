package management.studentManagement;
import java.util.Scanner;
public class StudentRecordMGMT {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many students you want to enter");
        int size = scanner.nextInt();
        StudentRecordSystem system = new StudentRecordSystem(size);
        System.out.println("What would you like to do ?");
        System.out.println("1. Add Student");
        System.out.println("2. Search student");
        System.out.println("3. Display all students");
        System.out.println("4. Exit");
        boolean stop = true;
        while (stop){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    if(system.count >= system.students.length){
                        System.out.println("Maximum students reached");
                    }else {
                        System.out.println("Enter student ID: ");
                        int sid = scanner.nextInt();
                        sid = system.validateIdAge(sid);
                        scanner.nextLine();

                        System.out.println("Enter student name: ");
                        String name = scanner.nextLine();
                        name = system.validateString(name, "Name");

                        System.out.println("Enter student department: ");
                        String dept = scanner.nextLine();
                        dept = system.validateString(dept, "Department");

                        System.out.println("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        age = system.validateIdAge(age);
                        system.addStudent(new Student(sid, name, dept, age));
                    }
                    break;

                case 2:
                    System.out.println("Enter student id to search");
                    system.getStudent(scanner.nextInt());
                    break;

                case 3:
                    system.displayAllStudents();
                    break;

                case 4:
                    System.out.println("All operation performed successfully");
                    return;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
