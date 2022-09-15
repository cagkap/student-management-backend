package cagla.studentmanagement.exam;

import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.lecturer.LecturerService;
import cagla.studentmanagement.researchAssistant.Assistant;
import cagla.studentmanagement.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Exam {

    @Id
    @GeneratedValue
    private Long id;

    private String  name;
    private  String info;

    private String time;
    private  String  room;




    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH})
    private Course course;



    public Exam(Long id,String name,String info,String time,String room,Course course){

        this.info=info;
        this.id=id;
        this.room=room;

        this.time=time;

        this.name=name;

        this.course=course;

    }




}
