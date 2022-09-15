package cagla.studentmanagement.researchAssistant;

import cagla.studentmanagement.MessageResponse;
import cagla.studentmanagement.student.AddStudentRequest;
import cagla.studentmanagement.student.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class AssistantController {

    private final AssistantService assistantService;
    @PostMapping("/addAssistant")
    public MessageResponse addAssistant(@RequestBody @Valid AddAssistantRequest request) {

        return assistantService.addAssistant(request.toEntity());
    }

    @GetMapping("/assistants")
    public List<AssistantResponse> getAllAssistants() {
        return assistantService.getAllAssistants()
                .stream()
                .map(AssistantResponse::fromEntity)
                .toList();
    }

}
