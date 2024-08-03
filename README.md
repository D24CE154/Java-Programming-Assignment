# Student Management System

## Overview

This project is a Student Management System that includes functionalities for managing students, courses, enrollments, and grades. It is divided into three main modules:

1. **Student Management System**:
   - Manages student data and records.

2. **Course Enrollment System**:
   - Manages course data and student enrollments in courses.

3. **Grading and Result Declaration System**:
   - Manages grading for students and result declarations.

## Project Structure

The project is organized into the following packages:

- **`studentManagement`**:
  - `Student.java` - Represents a student with properties like ID, name, and department.
  - `StudentManagement.java` - Main class for managing student operations.
  - `StudentRecordSystem.java` - Handles student records including addition, deletion, display, and search.

- **`courseManagement`**:
  - `Course.java` - Represents a course with properties like ID, name, and credits.
  - `Enrollment.java` - Manages student enrollments in courses.
  - `CourseEnrollment.java` - Main class for course enrollment operations.

- **`gradeManagement`**:
  - `Student.java` - Represents a student (if needed separately from `studentManagement`).
  - `Grade.java` - Represents grading details for students.
  - `GradingSystem.java` - Manages grading logic and operations.
  - `GradingSystemManagement.java` - Main class for managing grading operations.
