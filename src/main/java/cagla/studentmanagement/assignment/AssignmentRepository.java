package cagla.studentmanagement.assignment;

import cagla.studentmanagement.assignment.Assignment;
import cagla.studentmanagement.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> getAllAssignmentsByCourseId(Long id);
}
