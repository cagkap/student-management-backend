package cagla.studentmanagement.Login;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;



    @RequestMapping(value="/login-page",method = {RequestMethod.POST})
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }


}