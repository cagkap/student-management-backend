package cagla.studentmanagement;

import cagla.studentmanagement.Login.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public  interface  UserRepository extends JpaRepository<CustomUser,Long> {


    CustomUser findByUsername(String username);





}
