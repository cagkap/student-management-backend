package cagla.studentmanagement;


import cagla.studentmanagement.Login.CustomUser;
import org.apache.catalina.User;

public record UserResponse (
        Long id,
        String username,

        String password,
       String userType


) {
    public static UserResponse fromEntity(CustomUser customUser) {
        return new UserResponse(
              customUser.getId(),
                customUser.getUsername(),
                customUser.getPassword(),
                customUser.getUserType()





        );
    }
}
