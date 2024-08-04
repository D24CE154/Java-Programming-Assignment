package management.gradeManagement;

import management.courseManagement.Course;
import management.studentManagement.Student;

/*
 * Represents a grade given to a student for a particular course.
 */
public class Grade {
    private Student student;  // Student who received the grade
    private Course course;   // Course for which the grade is given
    private char grade;      // Grade received by the student

    /*
     * Constructor to initialize a Grade object.
     */
    public Grade(Student student, Course course, char grade) {
        this.student = student;  // Set student
        this.course = course;    // Set course
        this.grade = grade;      // Set grade
    }

    /**]
     * Gets the ID of the student.
     */
    public int getStudentId() {
        return student.getStudentId();
    }

    /*
     * Gets the ID of the course.
     */
    public int getCourseId() {
        return course.getCourseID();
    }

    /*
     * Gets the name of the course.
     */
    public String getCourseName() {
        return course.getCourseName();
    }

    /*
     * Gets the grade received by the student.
     */
    public char getGrade() {
        return grade;
    }

    /*
     * Returns a string representation of the Grade object.
     */
    @Override
    public String toString() {
        return "Student: " + student.getStudentName() +
                " (ID: " + student.getStudentId() + "), " +
                "Course: " + course.getCourseName() +
                " (ID: " + course.getCourseID() + "), Grade: " + grade;
    }
}
