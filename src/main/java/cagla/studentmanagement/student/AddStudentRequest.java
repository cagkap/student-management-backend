package cagla.studentmanagement.student;

import cagla.studentmanagement.Login.Authority;
import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;



public record AddStudentRequest(
        @NotEmpty
        Long id,

        @NotEmpty
        String username,


        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String surname,

        @NotEmpty
        @Email
        @Size(max = 255)
        String email,


        @NotEmpty
        String userType



) {


    public Student toEntity() {


        final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        return new Student(
                null,
                username,
                passwordEncoder.encode("fdsgsldkmgflsd"),
                List.of(new Authority("USER")),
                name,
                surname,
                email,
                "student"

        );
    }
}