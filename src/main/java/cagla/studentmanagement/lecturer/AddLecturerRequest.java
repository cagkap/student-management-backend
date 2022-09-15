package cagla.studentmanagement.lecturer;

import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.researchAssistant.Assistant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public record AddLecturerRequest(
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


    public Lecturer toEntity() {


        final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        return new Lecturer(
                null,
               username,
                passwordEncoder.encode("mslgmds"),
                List.of(new Authority("USER")),
                name,
                surname,
                email,
                "lecturer"

        );
    }
}