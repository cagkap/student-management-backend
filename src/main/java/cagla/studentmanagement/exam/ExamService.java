package cagla.studentmanagement.exam;


import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.ResultType;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    public final ExamRepository examRepository;

    public List<Exam> getAllExamsByCourseId(Long courseId) {

        return examRepository.getAllCoursesByCourseId(courseId);

    }
    public MessageResponse addExam(Exam exam) {
        examRepository.save(exam);

        return new MessageResponse("Exam has been added successfully", ResultType.SUCCESS);
    }
}
