package cagla.studentmanagement.lecturer;


import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.Login.CustomUser;
import cagla.studentmanagement.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Entity
@Getter
public class Lecturer extends CustomUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String email;



    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH,},fetch = FetchType.LAZY)
    @JoinTable(name = "lecturer_courses", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "lecturer_id"))
    private List<Course> courses=new ArrayList<Course>();

    public Lecturer(Long id, String username, String password, List<Authority> authorities, String name, String surname, String email, String userType) {
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
        course.setLecturer(this);
    }
}
