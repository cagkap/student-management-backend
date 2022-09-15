package cagla.studentmanagement;

import cagla.studentmanagement.Login.CustomUser;
import cagla.studentmanagement.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

        @Autowired
        private UserRepository userRepository;

        private StudentRepository studentRepository;



    public List<CustomUser> listAllUsers(){
            return userRepository.findAll();
        }
        public CustomUser getUserTypeByName(String username){
                return userRepository.findByUsername(username);
        }

}
