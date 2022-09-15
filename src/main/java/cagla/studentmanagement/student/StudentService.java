package cagla.studentmanagement.student;

import cagla.studentmanagement.course.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import  cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.ResultType;
import  cagla.studentmanagement.student.Student;
import  cagla.studentmanagement.student.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse("Student has been added successfully", ResultType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }

    /*public MessageResponse updateStudent(Long id, Student newStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.update(newStudent);
        studentRepository.save(existingStudent);
        return new MessageResponse("Student with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }*/

    public MessageResponse deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return new MessageResponse("Student with id %d has been deleted", ResultType.SUCCESS);
    }

    public List<Course> getStudentCourses(String username){
       return studentRepository.getCoursesByUsername(username);

    }

    public Long getIdByUsername(String username){
        Student student=studentRepository.findByUsername(username);
        return student.getId();
    }

    public MessageResponse addCourseById(Long id,Course newCourse){
        Student existingStudent=getStudentById(id);
        if(existingStudent.checkCourse(newCourse)){
            return new MessageResponse("Already registered", ResultType.ERROR);
        }
        existingStudent.addCourse(newCourse);
        studentRepository.save(existingStudent);
        return new MessageResponse("Course is added to student", ResultType.SUCCESS);


    }
    public String getNameByUsername(String username){
        Student student=studentRepository.findByUsername(username);
        return student.getName()+" "+student.getSurname();
    }

}