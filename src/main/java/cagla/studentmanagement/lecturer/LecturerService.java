package cagla.studentmanagement.lecturer;

import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.ResultType;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.course.CourseRepository;
import cagla.studentmanagement.researchAssistant.Assistant;
import cagla.studentmanagement.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService {

    public final LecturerRepository lecturerRepository;

    @Autowired
    public final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        lecturerRepository.save(new Lecturer(null, "nazlı.ikizler", passwordEncoder.encode("nazlı.ikizler"),List.of(new Authority("USER")),"Nazlı","İkizler" ,"nazlı@gmail.com","lecturer"));

        lecturerRepository.save(new Lecturer(null, "ebru.gokalp", passwordEncoder.encode("ebru.gokalp"),List.of(new Authority("USER")),"Ebru","Gökalp" ,"ebru@gmail.com","lecturer"));

        Lecturer lecturer=new Lecturer(null, "pinar.duygulu", passwordEncoder.encode("pinar.duygulu"),List.of(new Authority("USER")),"Pınar","Duygulu" ,"pinar@gmail.com","lecturer");

        lecturer.addCourse(new Course(null, "Fundamentals of AI", "Technical elective course","elective","BBM405","Tuesday 12:00-14:00" ,"D10",null));
        lecturerRepository.save(lecturer);




    }

    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public MessageResponse addLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);

        return new MessageResponse("lecturer has been added successfully", ResultType.SUCCESS);
    }

    public Lecturer getLecturerByName(String name) {
        return lecturerRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Student with name %s not found"));
    }
    public Lecturer getLecturerById(Long id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }
    public Long getIdByUsername(String username){
        Lecturer lecturer=lecturerRepository.findByUsername(username);
        return lecturer.getId();
    }

    public String getNameByUsername(String username){
        Lecturer lecturer=lecturerRepository.findByUsername(username);
        return lecturer.getName()+" "+lecturer.getSurname();

    }

}
