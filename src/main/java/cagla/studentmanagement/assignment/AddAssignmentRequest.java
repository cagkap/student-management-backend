package cagla.studentmanagement.assignment;

import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.exam.Exam;
import cagla.studentmanagement.researchAssistant.Assistant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.IOException;
import java.util.List;

public record AddAssignmentRequest(
        @NotEmpty
        Long id,

        @NotEmpty
        String definition,


        @NotEmpty

        String deadline,



        @NotEmpty
        MultipartFile file,
        @NotEmpty
        Long courseId




) {


    public Assignment toEntity(Course course) throws IOException {

        File newFile=new File("C:\\Users\\Cagla\\student-management"+file.getOriginalFilename());
        file.transferTo(newFile);

        return new Assignment(
                null,
                definition,
                deadline,
                newFile,
                course

        );
    }
}