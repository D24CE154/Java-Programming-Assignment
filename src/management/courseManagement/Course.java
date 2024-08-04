package management.courseManagement;

/*
Represents a course with an ID, name, and number of credits.
 */
public class Course {
    // Fields for storing course information
    private int courseId;        // Unique identifier for the course
    private String courseName;   // Name of the course
    private int courseCredits;   // Number of credits for the course

    /**
     * Constructor to initialize a Course object.
     * @param courseId       Unique identifier for the course
     * @param courseName     Name of the course
     * @param courseCredits  Number of credits for the course
     */
    public Course(int courseId, String courseName, int courseCredits) {
        this.courseId = courseId;        // Set course ID
        this.courseName = courseName;    // Set course name
        this.courseCredits = courseCredits;  // Set course credits
    }

    // Used to get the course id.
    public int getCourseID() {
        return courseId;
    }

    // Used to get the course name.
    public String getCourseName() {
        return courseName;
    }

    // Used to get the course credits.
    public int getCredits() {
        return courseCredits;
    }

    //Returns a string representation of the Course object.
    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Name: " + courseName + ", Credits: " + courseCredits;
    }
}