package cagla.studentmanagement.exam;

import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.exam.Exam;
import cagla.studentmanagement.researchAssistant.Assistant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public record AddExamRequest(
        @NotEmpty
        Long id,

        @NotEmpty
        String name,


        @NotEmpty
        @Size(max = 255)
        String info,
        @NotEmpty
        @Size(max = 255)
        String time,

        @NotEmpty

        String room,


        @NotEmpty
        Long courseId



) {


    public Exam toEntity(Course course) {



        return new Exam(
                null,
                name,
                info,
                time,
               room,
                course

        );
    }
}