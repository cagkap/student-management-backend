package cagla.studentmanagement.course;


import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.ResultType;
import cagla.studentmanagement.admin.Admin;
import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.lecturer.LecturerRepository;
import cagla.studentmanagement.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    public final CourseRepository courseRepository;

    public final LecturerRepository lecturerRepository;

    private final PasswordEncoder passwordEncoder;




    @PostConstruct
    public void init() {


        Course course= new Course(null, "Data Structures", "Second year course","Compulsory","BBM201","Sunday 12:00-14:00" ,"D8",new Lecturer(null, "erkut.erdem", passwordEncoder.encode("erkut.erdem"),List.of(new Authority("USER")),"Erkut","Erdem" ,"erkut@gmail.com","lecturer"));



        courseRepository.save(course);




    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public MessageResponse updateCourse(Long id,Course newCourse) {
        Course existingCourse = getCourseById(id);

        existingCourse.update(newCourse);
        courseRepository.save(existingCourse);
        return new MessageResponse("Course with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }
    public MessageResponse deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return new MessageResponse("Course with id %d has been deleted", ResultType.SUCCESS);
    }
    public MessageResponse addCourse(Course course) {
        courseRepository.save(course);

        return new MessageResponse("Course has been added successfully", ResultType.SUCCESS);
    }


    public List<Course> getAllTagsByTutorialId(Long studentId) {

       return courseRepository.findCoursesByStudentsId(studentId);

    }
    public List<Course> getAllCoursesByLecturerId(Long lecturerId) {

        return courseRepository.findCoursesByLecturerId(lecturerId);

    }


}
