package management.studentManagement;

public class Student {
    // Instance variables for storing student details
    private int studentId;
    private String studentName;
    private String department;
    private int age;

    // Constructor to initialize a Student object
    public Student(int studentId, String studentName, String department, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.age = age;
    }

    // Getter method for student ID
    public int getStudentId() {
        return studentId;
    }

    // Getter method for student name
    public String getStudentName() {
        return studentName;
    }

    // Getter method for department
    public String getDepartment() {
        return department;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Override toString method to provide a string representation of the student
    @Override
    public String toString() {
        return "Student ID: " + studentId +
                "\nName: " + studentName +
                "\nDepartment: " + department +
                "\nAge: " + age;
    }
}