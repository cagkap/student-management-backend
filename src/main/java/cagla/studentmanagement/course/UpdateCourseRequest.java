package cagla.studentmanagement.course;

import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.lecturer.LecturerRepository;
import cagla.studentmanagement.lecturer.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public record UpdateCourseRequest (

        @NotEmpty
        Long id,
        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String definition,

        @Size(max = 255)
        String type,
        @NotEmpty
        @Size(min = 7, max = 7)
        String code,

        String time,

        String room,

        Long lecturerId
) {

public Course toEntity(Lecturer lecturer) {



        return new Course(
                id,
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
