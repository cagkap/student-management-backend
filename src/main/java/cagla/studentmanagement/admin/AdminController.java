/*package cagla.studentmanagement.admin;

import cagla.studentmanagement.Login.CustomUser;
import cagla.studentmanagement.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AdminController {


    private final UserService userService;
    @GetMapping("/users")

    public List<CustomUser> getUsers(){

        return userService.listAllUsers();
    }

}
*/