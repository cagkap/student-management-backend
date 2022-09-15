package cagla.studentmanagement.student;


import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.Login.CustomUser;
import cagla.studentmanagement.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Student extends CustomUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String email;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses=new ArrayList<Course>();

    public Student(Long id, String username, String password, List<Authority> authorities, String name, String surname, String email,String userType) {
        this.setId(id);
        this.setPassword(password);
        this.setAuthorities(authorities);
        setUsername(username);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.setUserType(userType);

    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public boolean checkCourse(Course course){
        return this.courses.contains(course);
    }


}
