package cagla.studentmanagement.course;

import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.assignment.AddAssignmentRequest;
import cagla.studentmanagement.assignment.Assignment;
import cagla.studentmanagement.assignment.AssignmentService;
import cagla.studentmanagement.exam.AddExamRequest;
import cagla.studentmanagement.exam.Exam;
import cagla.studentmanagement.exam.ExamResponse;
import cagla.studentmanagement.exam.ExamService;
import cagla.studentmanagement.lecturer.AddLecturerRequest;
import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.lecturer.LecturerRepository;
import cagla.studentmanagement.lecturer.LecturerService;
import cagla.studentmanagement.student.StudentResponse;
import cagla.studentmanagement.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @Autowired
    private final LecturerService lecturerService;
    @Autowired
    private final ExamService examService;

    @Autowired
    private final AssignmentService assignmentService;


    @GetMapping("/courses")
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses()
                .stream()
                .map(CourseResponse::fromEntity)
                .toList();
    }

    @PutMapping("/courses/update-lecture/{id}")
    public MessageResponse updateStudent(@RequestBody @Valid UpdateCourseRequest request,
                                         @PathVariable Long id) {
        Lecturer updatedLecturer = lecturerService.getLecturerById(request.lecturerId());

        return courseService.updateCourse(id, request.toEntity( updatedLecturer));
    }

    @DeleteMapping("/courses/delete-lecture/{id}")
    public MessageResponse deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

    @PostMapping("/addCourse")
    public MessageResponse addCourse(@RequestBody @Valid AddCourseRequest request) {
        Lecturer updatedLecturer = lecturerService.getLecturerById(request.lecturerId());

        return courseService.addCourse(request.toEntity(updatedLecturer));
    }

    @GetMapping("/student/{studentId}/courses")
    public List<CourseResponse> getAllCoursesByStudent(@PathVariable(value = "studentId") Long studentId) {

        return courseService.getAllTagsByTutorialId(studentId).stream()
                .map(CourseResponse::fromEntity)
                .toList();

    }
    @GetMapping("/lecturer/{lecturerId}/courses")
    public List<CourseResponse> getAllCoursesByLecturer(@PathVariable(value = "lecturerId") Long lecturerId) {

        return courseService.getAllCoursesByLecturerId(lecturerId).stream()
                .map(CourseResponse::fromEntity)
                .toList();

    }

    @PostMapping("/addExamToCourse")
    public MessageResponse addExam(@RequestBody @Valid AddExamRequest request
                                   ){

        Course course = courseService.getCourseById(request.courseId());
        Exam exam=request.toEntity(course);
        course.addExam(exam);
        return examService.addExam(exam);



    }

    @PostMapping(path="/addAssignmentToCourse")
    public MessageResponse addAssignment(@RequestPart Assignment assignment, @RequestPart MultipartFile document
    ) throws IOException {

        /*Course course = courseService.getCourseById(request.courseId());
        Assignment assignment =request.toEntity(course);
        course.addAssignment(assignment);*/
        return assignmentService.addAssignment(assignment);



    }
}

