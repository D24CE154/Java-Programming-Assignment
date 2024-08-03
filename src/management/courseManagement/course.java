package management.courseManagement;

public class course {
    private int courseId;
    private String courseName;
    private int courseCredits;
    public course(int courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public int getCourseID() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCredits() {
        return courseCredits;
    }
    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Name: " + courseName + ", Credits: " + courseCredits;
    }
}
