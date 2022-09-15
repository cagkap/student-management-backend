package cagla.studentmanagement.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByStudentsId(Long studentId);

    List<Course> findCoursesByLecturerId(Long lecturerId);
}
