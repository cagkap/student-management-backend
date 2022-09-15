package cagla.studentmanagement.course;


import cagla.studentmanagement.exam.ExamResponse;
import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.student.Student;
import cagla.studentmanagement.student.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public record CourseResponse(
        Long id,
        String  name,
        String definition,
        String type,
        String code,
        String time,
        String  room,
        String lecturerName,
        List<ExamResponse> exams

) {


    public static CourseResponse fromEntity(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getName(),
                course.getDefinition(),
                course.getType(),
                course.getCode(),
                course.getTime(),
                course.getRoom(),
                course.getLecturer().getName()+" "+course.getLecturer().getSurname(),
                course.getExams().stream().map(ExamResponse::fromEntity)
                .toList()




        );
    }

    }

