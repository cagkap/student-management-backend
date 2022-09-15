package cagla.studentmanagement.Login;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;


public record LoginRequest(
        @NotNull
        String username,
        @NotNull
        String password



) {
}
