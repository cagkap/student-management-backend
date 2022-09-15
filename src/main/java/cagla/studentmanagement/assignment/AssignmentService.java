package cagla.studentmanagement.assignment;


import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.ResultType;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    public final AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignmentsByCourseId(Long courseId) {

        return assignmentRepository.getAllAssignmentsByCourseId(courseId);

    }
    public MessageResponse addAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);

        return new MessageResponse("Assignment has been added successfully", ResultType.SUCCESS);
    }
}
