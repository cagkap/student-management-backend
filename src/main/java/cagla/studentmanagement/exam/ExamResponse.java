package cagla.studentmanagement.exam;

import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.exam.Exam;


public record ExamResponse(
        Long id,
        String  name,
        String info,

        String time,
        String  room,
        String courseName

) {


    public static ExamResponse fromEntity(Exam exam) {
        return new ExamResponse(
                exam.getId(),
                exam.getName(),
                exam.getInfo(),

                exam.getTime(),
                exam.getRoom(),
                exam.getCourse().getName()




        );
    }

}