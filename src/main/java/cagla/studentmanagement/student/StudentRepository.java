package cagla.studentmanagement.student;

import cagla.studentmanagement.Login.CustomUser;
import cagla.studentmanagement.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select courses from student u where u.username=:username",nativeQuery = true)
    List<Course> getCoursesByUsername(String username);

    List<Student> findStudentsByCoursesId(Long courseId);

    Student findByUsername(String string);


}
