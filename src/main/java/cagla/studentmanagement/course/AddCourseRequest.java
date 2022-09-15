package cagla.studentmanagement.course;



import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.lecturer.Lecturer;

import org.aspectj.weaver.ast.Not;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public record AddCourseRequest(


        @NotEmpty
        String type,


        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String definition,

        @NotEmpty

        String code,


        @NotEmpty
        String time,

        @NotEmpty
        String room,

        @NotEmpty
        Long lecturerId



) {


    public Course toEntity(Lecturer lecturer) {



        return new Course(
                null,
                name,
                definition,
               type,
                code,
                time,
                room,
                lecturer


        );
    }
}