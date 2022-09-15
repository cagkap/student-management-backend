package cagla.studentmanagement.lecturer;


import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.researchAssistant.AddAssistantRequest;
import cagla.studentmanagement.researchAssistant.AssistantService;
import cagla.studentmanagement.student.StudentResponse;
import cagla.studentmanagement.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static cagla.studentmanagement.student.StudentController.removeLastChar;

@RestController
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping("/lecturers")
    public List<LecturerResponse> getAllLecturers() {
        return lecturerService.getAllLecturers()
                .stream()
                .map(LecturerResponse::fromEntity)
                .toList();
    }


    @PostMapping("/addLecturer")
    public MessageResponse addLecturer(@RequestBody @Valid AddLecturerRequest request) {

        return lecturerService.addLecturer(request.toEntity());
    }

    @PostMapping("/getLecturer")
    public Long getLecturerId(@RequestBody String username){
        String uses= removeLastChar(username);
        return lecturerService.getIdByUsername(uses);
    }
    @PostMapping("/getLecturerName")
    public String getLecturerName(@RequestBody String username){
        String uses= removeLastChar(username);
        return lecturerService.getNameByUsername(uses);
    }


}
