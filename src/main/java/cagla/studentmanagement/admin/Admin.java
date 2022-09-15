package cagla.studentmanagement.admin;

import cagla.studentmanagement.Login.Authority;
import cagla.studentmanagement.Login.CustomUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Admin extends CustomUser {
    @Id
    @GeneratedValue
    private Long id;

    public Admin(Long id, String username, String password, List<Authority> authorities,String userType){
        this.setId(id);
        this.setAuthorities(authorities);
        this.setPassword(password);
        this.setUsername(username);
        this.setUserType(userType);
    }
}
