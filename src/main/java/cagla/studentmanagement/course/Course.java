package cagla.studentmanagement.course;

import cagla.studentmanagement.assignment.Assignment;
import cagla.studentmanagement.exam.Exam;
import cagla.studentmanagement.exam.ExamResponse;
import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.lecturer.LecturerRepository;
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

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String  name;
    private  String definition;
    private String type;
    private String code;
    private String time;
    private  String  room;


    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.LAZY)
    private Lecturer lecturer;

    @ManyToMany(mappedBy="courses",cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH})
    private List<Student> students=new ArrayList<Student>();

    @ManyToMany(mappedBy="courses",cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH})
    private List<Assistant> assistants=new ArrayList<Assistant>();

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH,})
    private List<Exam> exams= new ArrayList<>();

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH,})
    private List<Assignment> assignments= new ArrayList<>();


    public Course(Long id,String name,String definition,String type, String code,String time,String room,Lecturer lect){
        this.code=code;
        this.definition=definition;
        this.id=id;
        this.room=room;
        this.lecturer=lect;
        this.time=time;
        this.type=type;
        this.name=name;

    }



    public void update(Course newCourse) {
        this.name = newCourse.name;
        this.definition = newCourse.definition;
        this.code = newCourse.code;
        this.id = newCourse.id;
        this.room = newCourse.room;
        this.lecturer = newCourse.lecturer;
        this.time = newCourse.time;
        this.type = newCourse.type;

    }
    public void addAssistant(Assistant assistant) {
        this.assistants.add(assistant);
        assistant.getCourses().add(this);
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);

        exam.setCourse(this);

    }
    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);

        assignment.setCourse(this);

    }



}
