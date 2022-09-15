package cagla.studentmanagement.Login;

import cagla.studentmanagement.UserRepository;
import cagla.studentmanagement.admin.Admin;
import cagla.studentmanagement.course.Course;
import cagla.studentmanagement.lecturer.Lecturer;
import cagla.studentmanagement.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        userRepository.save(new Student(null, "21946275", passwordEncoder.encode("21946275"),List.of(new Authority("USER")),"Çağla","Kaplan","cagla@gmail.com" ,"student"));
        Student student= new Student(null, "21946276", passwordEncoder.encode("21946276"),List.of(new Authority("USER")),"Şevval","Şenel","sevval@gmail.com","student" );
        student.addCourse(new Course(null, "Algorithms", "Second year course","Compulsory","BBM202","Monday 12:00-15:00" ,"D8",new Lecturer(null, "engin.demir", passwordEncoder.encode("engin.demir"),List.of(new Authority("USER")),"Engin","Demir" ,"engin@gmail.com","lecturer")));
        userRepository.save(student);
        userRepository.save(new Admin(null, "admin", passwordEncoder.encode("admin"),List.of(new Authority("USER"), new Authority("ADMIN")),"admin"));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);

    }


}