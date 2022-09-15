package cagla.studentmanagement.student;

public record StudentResponse(
        Long id,
        String username,

        String password,
        String name,
        String surname,
        String email,
        String userType
) {
    public static StudentResponse fromEntity(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getUsername(),
                student.getPassword(),
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getUserType()


                );
    }
}
