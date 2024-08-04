package management.gradeManagement;

import management.studentManagement.Student;

/**
 * Manages grading for students, including adding grades, course credits,
 * and calculating GPA.
 */
public class gradingSystem {
    private Student[] students;       // Array of students
    private Grade[] grades;          // Array of grades for students
    private int[] courseCredits;     // Array of course credits
    private int studentCount;        // Number of students
    private int gradeCount;          // Number of grades added

    /*
     * Constructor to initialize the grading system.
     */
    public gradingSystem(Student[] students, int[] courseCredits) {
        this.students = students;  // Set array of students
        this.courseCredits = courseCredits;  // Set array of course credits
        this.studentCount = students.length;  // Set number of students
        this.gradeCount = 0;  // Initialize grade count
        this.grades = new Grade[students.length * courseCredits.length];  // Initialize grades array
    }

    /*
     * Adds a grade to the system.
     */
    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;  // Add grade to array
            gradeCount++;  // Increment grade count
        } else {
            System.out.println("Grades array is full.");
        }
    }

    /*
     * Adds or updates course credits for a given course.
     */
    public void addCourseCredits(int courseID, int credits) {
        if (courseID >= 0 && courseID < courseCredits.length) {
            courseCredits[courseID] = credits;
        } else {
            System.out.println("Invalid course ID.");
        }
    }

    /*
     * Calculates the GPA for a student based on their grades and course credits.
     */
    public double calculateGPA(int studentID) {
        int totalPoints = 0;  // Total grade points
        int totalCredits = 0; // Total credits
        for (Grade grade : grades) {
            if (grade != null && grade.getStudentId() == studentID) {
                int courseID = grade.getCourseId();
                int credits = courseCredits[courseID];
                int gradePoints = gradeToPoints(grade.getGrade());

                totalPoints += gradePoints * credits;  // Add to total points
                totalCredits += credits;  // Add to total credits
            }
        }

        // Return GPA calculation
        if (totalCredits == 0) {
            return 0.0;  // Return 0 if no credits
        } else {
            return (double) totalPoints / totalCredits;  // Calculate and return GPA
        }
    }

    /*
     * Converts a letter grade to grade points.
     */
    private int gradeToPoints(char grade) {
        return switch (grade) {
            case 'A' -> 4;
            case 'B' -> 3;
            case 'C' -> 2;
            case 'D' -> 1;
            case 'F' -> 0;
            default -> 0;
        };
    }
}
