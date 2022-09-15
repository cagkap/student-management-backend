package cagla.studentmanagement.student;

import cagla.studentmanagement.Login.Authority;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public record UpdateStudentRequest(

        @NotEmpty
        Long id,

        @NotEmpty
        String username,

        @NotEmpty
        String password,

        @NotEmpty
        List<Authority> authorities,
        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String surname,
        @Email
        @Size(max = 255)
        String email,
        String userType

) {

    public Student toEntity() {
        return new Student(
                id,
                username,
                password,
                authorities,
                name,
                surname,
                email,
                userType
        );
    }
}