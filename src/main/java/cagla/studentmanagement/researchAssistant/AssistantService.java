package cagla.studentmanagement.researchAssistant;


import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.ResultType;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.course.CourseRepository;
import cagla.studentmanagement.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistantService {

    public final AssistantRepository assistantRepository;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        assistantRepository.save(new Assistant("İmre", "Kosdik", "imre@gmail.com",null,"imre.kosdik",passwordEncoder.encode("imre.kosdik"),"assistant",List.of(new Authority("USER"))));

    }

    public List<Assistant> getAllAssistants() {
        return assistantRepository.findAll();
    }

    public MessageResponse addAssistant(Assistant assistant) {
        assistantRepository.save(assistant);

        return new MessageResponse("Assistant has been added successfully", ResultType.SUCCESS);
    }



}
