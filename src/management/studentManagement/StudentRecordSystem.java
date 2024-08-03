package management.studentManagement;
import java.util.Scanner;
public class StudentRecordSystem {
    Scanner scan =new Scanner(System.in);
    Student students[];
    int count ;
    public StudentRecordSystem(int size){
        students = new Student[size];
    }

    public void addStudent(Student student){
        if (isExistingStudent(student)){
            System.out.println("Student exists in department" + student.getDepartment()+" ID:" + student.getStudentId());
            return;
        }
        System.out.println("Student record added successfully");
        students[count] = student;
        count++;
    }
    private boolean isExistingStudent(Student newStudent) {
        for (int i = 0; i < count; i++) {
            Student existingStudent = students[i];
            if (existingStudent.getStudentId() == newStudent.getStudentId() && existingStudent.getDepartment().equals(newStudent.getDepartment())) {
                return true;
            }
        }
        return false;
    }

    String validateString(String input, String field) {
        while (input == null || input.trim().isEmpty()) {
            System.out.println(field + " cannot be empty. Please enter a valid " + field + ":");
            input = scan.nextLine();
        }
        return input;
    }

    int validateIdAge(int ageOrId) {
        while (ageOrId <= 0) {
            System.out.println("Number must be greater than 0. Please enter a valid number:");
            ageOrId = scan.nextInt();
            scan.nextLine();
        }
        return ageOrId;
    }
    public void displayAllStudents(){
        if(count==0){
            System.out.println("Records are empty");
        }else {
            for (int i = 0; i <= count-1; i++) {
                System.out.println(students[i]);
            }
        }
    }
    public void getStudent(int searchId) {
        boolean studentFound = false;
        if (count == 0) {
            System.out.println("Records are empty");
        } else {
            for (int i = 0; i < count; i++) {
                if (students[i].getStudentId() == searchId) {
                    System.out.println("Student found");
                    System.out.println();
                    System.out.println(students[i]);
                    System.out.println();
                    studentFound = true;
                }
            }
        }
            if(!studentFound){
                System.out.println("Student not found with ID: "+searchId);
            }
    }
}