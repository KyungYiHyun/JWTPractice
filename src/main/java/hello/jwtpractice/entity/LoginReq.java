package hello.jwtpractice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class LoginReq {
    private String email;
    private String userPassword;
}
