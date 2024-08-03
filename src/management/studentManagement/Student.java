package management.studentManagement;

public class Student {
    private int studentId;
    private String studentName;
    private String department;
    private int age;
    public Student(int studentId , String studentName , String department , int age){
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.age = age;
    }
    public int getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getDepartment(){
        return department;
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Student ID:" +studentId+ "\nName: "+studentName+ "\nDepartment: "+department+ "\nAge: "+age;
    }
}
