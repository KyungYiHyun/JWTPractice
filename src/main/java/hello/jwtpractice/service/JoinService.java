package hello.jwtpractice.service;

import hello.jwtpractice.dto.JoinDTO;
import hello.jwtpractice.entity.UserEntity;
import hello.jwtpractice.reposiroty.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO){

        String username = joinDTO.getEmail();
        String password = joinDTO.getUserPassword();


        Boolean isExist = userRepository.existsByEmail( username);

        if(isExist){
            return;
        }

        UserEntity data = new UserEntity();

        data.setEmail(username);
        data.setUserPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }

}
