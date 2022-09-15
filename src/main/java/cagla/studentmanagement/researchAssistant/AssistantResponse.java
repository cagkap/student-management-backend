package cagla.studentmanagement.researchAssistant;

import cagla.studentmanagement.course.Course;


public record AssistantResponse (
        Long id,
        String name,
        String surname,
        String email,
        String userType,
        String username
){

    public static AssistantResponse fromEntity(Assistant assistant) {
        return new AssistantResponse(
                assistant.getId(),
                assistant.getName(),
                assistant.getSurname(),
                assistant.getEmail(),
                assistant.getUserType(),
                assistant.getUsername()

        );
    }
}
