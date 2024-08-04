package management.courseManagement;

/*
 * Manages course enrollments, including enrolling students, dropping courses,
 * and displaying enrolled courses.
 */
public class enrollment {
    private Course[] courseCatalog;  // Array of available courses
    private int numOfCourses;        // Number of courses
    private int[][] studentCourses;  // 2D array to store student enrollments
    private int numOfStudents;       // Number of students


    /*
     * Constructor to initialize the enrollment system.
     */
    public enrollment(Course[] courseCatalog, int size) {
        this.courseCatalog = courseCatalog;  // Initialize course catalog
        this.numOfCourses = courseCatalog.length;  // Set number of courses
        this.numOfStudents = size;  // Set number of students
        this.studentCourses = new int[numOfStudents * numOfCourses][numOfCourses];  // Initialize studentCourses array
    }

    /*
     * Enrolls a student in a course.
     */
    public void enroll(int studentID, int courseID) {
        if (courseID < 0 || courseID >= numOfCourses) {
            System.out.println("Invalid Course ID.");
            return;
        }

        // Check if the student is already enrolled in the course
        for (int i = 0; i < numOfStudents; i++) {
            if (studentCourses[i][0] == studentID && studentCourses[i][1] == courseID) {
                studentCourses[i][2] = 1;  // Mark as enrolled
                System.out.println("Student ID " + studentID + " is already enrolled in Course ID " + courseID);
                return;
            }
        }

        // Enroll the student if the array has space
        if (numOfStudents < studentCourses.length) {
            studentCourses[numOfStudents][0] = studentID;
            studentCourses[numOfStudents][1] = courseID;
            studentCourses[numOfStudents][2] = 1;
            numOfStudents++;
            System.out.println("Student ID " + studentID + " enrolled in Course ID " + courseID);
        } else {
            System.out.println("Maximum number of enrollment records reached.");
        }
    }

    /*
     * Drops a course for a student.
     */
    public void drop(int studentID, int courseID) {
        // Search for the enrollment record and drop the course
        for (int i = 0; i < numOfStudents; i++) {
            if (studentCourses[i][0] == studentID && studentCourses[i][1] == courseID) {
                studentCourses[i][2] = 0;  // Mark as not enrolled
                System.out.println("Student ID " + studentID + " dropped Course ID " + courseID);
                return;
            }
        }
        System.out.println("Student ID " + studentID + " is not enrolled in Course ID " + courseID);
    }

    /*
     * Displays all courses a student is enrolled in.
     * studentID The ID of the student
     */
    public void getEnrolledCourses(int studentID) {
        System.out.println("Courses enrolled by Student ID " + studentID + ":");
        boolean enrolled = false;
        for (int i = 0; i < numOfStudents; i++) {
            if (studentCourses[i][0] == studentID && studentCourses[i][2] == 1) {
                int courseID = studentCourses[i][1];
                if (courseID >= 0 && courseID < courseCatalog.length) {
                    System.out.println(courseCatalog[courseID]);
                }
                enrolled = true;
            }
        }
        if (!enrolled) {
            System.out.println("No courses enrolled.");
        }
    }

    // Displays the list of all available courses.
    public void displayCourseCatalog() {
        for (Course course : courseCatalog) {
            System.out.println(course);  // Print course details
        }
    }

    /*
     * Finds a course by its ID.
     * courses Array of courses
     * courseID The ID of the course to find
     * Return's the Course object if found, otherwise null
     */
    public static Course findCourseById(Course[] courses, int courseID) {
        for (Course course : courses) {
            if (course.getCourseID() == courseID) {
                return course;
            }
        }
        return null;
    }
}