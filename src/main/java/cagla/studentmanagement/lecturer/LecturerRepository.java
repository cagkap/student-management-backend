package cagla.studentmanagement.lecturer;

import cagla.studentmanagement.Login.CustomUser;
import cagla.studentmanagement.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    Optional<Lecturer> findByName(String name);
    Lecturer findByUsername(String string);

    String findNameByUsername(String string);
}
