package cagla.studentmanagement.assignment;

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
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Assignment {

    @Id
    @GeneratedValue
    private Long id;

    private String  definition;
    private  String deadline;

    private File file;



    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH})
    private Course course;



    public Assignment(Long id,String definition,String deadline,File file,Course course){

        this.definition=definition;
        this.id=id;
        this.deadline=deadline;

        this.file=file;
        this.course=course;



    }




}
