package cagla.studentmanagement.lecturer;


import cagla.studentmanagement.lecturer.LecturerResponse;

public record LecturerResponse (
        Long id,
         String name,
         String surname,
         String email,
        String username,
        String password,
        String userType

) {
    public static LecturerResponse fromEntity(Lecturer lecturer) {
        return new LecturerResponse(
                lecturer.getId(),
                lecturer.getName(),
                lecturer.getSurname(),
                lecturer.getEmail(),
                lecturer.getUsername(),
                lecturer.getPassword(),
                lecturer.getUserType()


        );
    }
}
