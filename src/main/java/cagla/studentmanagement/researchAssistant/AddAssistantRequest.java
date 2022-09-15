package cagla.studentmanagement.researchAssistant;

import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.student.Student;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public record AddAssistantRequest(
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


    public Assistant toEntity() {


        final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        return new Assistant(
                name,
                surname,
                email,
               null,
                username,
                passwordEncoder.encode("dömfşldf"),
                "assistant",
                List.of(new Authority("USER"))

        );
    }
}