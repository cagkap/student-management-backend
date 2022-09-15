package cagla.studentmanagement.Login;

import cagla.studentmanagement.UserResponse;
import cagla.studentmanagement.UserService;
import cagla.studentmanagement.student.StudentResponse;
import cagla.studentmanagement.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userService.listAllUsers()
                .stream()
                .map(UserResponse::fromEntity)
                .toList();
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            System.out.println(authentication.getName());

            return authentication.getName();
        }
        else
            return "";
    }

    @PostMapping(value = "/type")
    @ResponseBody
    public String currentUserType(@RequestBody  String username){
        String uses= removeLastChar(username);
       CustomUser user= userService.getUserTypeByName(uses);
       return user.getUserType();
    }

    public static String removeLastChar(String str) {
        return removeLastChars(str, 1);
    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }
}
