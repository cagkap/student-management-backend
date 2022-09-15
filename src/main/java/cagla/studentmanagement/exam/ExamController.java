package cagla.studentmanagement.exam;

import cagla.studentmanagement.course.CourseResponse;
import cagla.studentmanagement.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    @GetMapping("/course/{courseId}/exam")
    public List<ExamResponse> getAllCoursesByLecturer(@PathVariable(value = "courseId") Long courseId) {

        return examService.getAllExamsByCourseId(courseId).stream()
                .map(ExamResponse::fromEntity)
                .toList();

    }
}
