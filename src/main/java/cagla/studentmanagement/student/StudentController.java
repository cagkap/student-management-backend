package cagla.studentmanagement.student;


import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.course.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/students")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentResponse::fromEntity)
                .toList();
    }

    @PostMapping("/addStudent")
    public MessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {

        return studentService.addStudent(request.toEntity());
    }

    @PostMapping("/student-courses")
    public List<CourseResponse> getCourses(@RequestBody String username){
        return studentService.getStudentCourses(username).stream()
                .map(CourseResponse::fromEntity)
                .toList();
    }

    @PostMapping("/getStudent")
    public Long getStudentId(@RequestBody String username){
        String uses= removeLastChar(username);
        return studentService.getIdByUsername(uses);
    }
    public static String removeLastChar(String str) {
        return removeLastChars(str, 1);
    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

    @GetMapping("/addCourseToStudent/{id}/{courseId}")
    public MessageResponse addCourse(@PathVariable Long courseId,
                                     @PathVariable Long id){
        Course course = courseService.getCourseById( courseId);
        return studentService.addCourseById(id,course);
    }

    @PostMapping("/getStudentName")
    public String getStudentName(@RequestBody String username){
        String uses= removeLastChar(username);
        return studentService.getNameByUsername(uses);
    }
}
