package management.courseManagement;

import java.util.Scanner;

/**
 * Manages course enrollment operations and interactions with users.
 */
public class courseEnrollment {

    // Array of available courses
    public static Course[] courseCatalog = new Course[]{
            new Course(1, "Computer Organization & Architecture", 4),
            new Course(2, "Data Structures", 5),
            new Course(3, "Discrete Mathematics and Algebra", 4),
            new Course(4, "Java Programming", 5),
            new Course(5, "Creativity Problem Solving & Innovation", 2),
            new Course(6, "Art of Programming", 2)
    };

    /**
     * Retrieves a Course object based on the given course ID.
     * @param courseId The ID of the course to retrieve
     * @return The Course object if found, otherwise null
     */
    public Course getCourse(int courseId) {
        for (Course course : courseCatalog) {
            if (course != null && course.getCourseID() == courseId) {
                return course;
            }
        }
        return null;
    }

    /**
    * Main method to handle user input and perform the tasks
    **/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Scanner for user input
        courseEnrollment CourseEnrollment = new courseEnrollment();  //instance of courseEnrollment
        System.out.println("Enter how many students you want to enter");
        int size = scanner.nextInt();  // Get the number of students
        enrollment Enrollment = new enrollment(CourseEnrollment.courseCatalog, size);

        // Display menu options
        System.out.println("What would you like to do ?");
        System.out.println("1. Display available courses");
        System.out.println("2. Enroll in a Course");
        System.out.println("3. Drop a Course");
        System.out.println("4. Get enrolled Course");
        System.out.println("5. Exit");

        // Loop to handle user choices
        while (true) {
            int choice = scanner.nextInt();  // Get user choice
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Enrollment.displayCourseCatalog();
                    break;

                case 2:
                    System.out.println("Enter your student id");
                    int sid = scanner.nextInt();
                    System.out.println("Enter Course id");
                    int cid = scanner.nextInt();
                    Enrollment.enroll(sid, cid);
                    break;

                case 3:
                    System.out.println("Enter your student id and Course id");
                    Enrollment.drop(scanner.nextInt(), scanner.nextInt());
                    break;

                case 4:
                    System.out.println("Enter your student id");
                    Enrollment.getEnrolledCourses(scanner.nextInt());
                    break;

                case 5:
                    System.out.println("All operations performed successfully");
                    return;  // Exit the program

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
