package cagla.studentmanagement.researchAssistant;

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
public class Assistant extends CustomUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String email;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "assistant_courses", joinColumns = @JoinColumn(name = "assistant_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses=new ArrayList<Course>();

    public Assistant(String name, String surname, String email, Long id, String username, String password, String userType, List<Authority> authorities) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.setPassword(password);
        this.setUsername(username);
        this.setId(id);
        this.setUserType(userType);
        this.setAuthorities(authorities);


    }
    public void addCourse(Course course) {
        this.courses.add(course);
        course.getAssistants().add(this);
    }

}
