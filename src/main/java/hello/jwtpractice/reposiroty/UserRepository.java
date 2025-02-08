package hello.jwtpractice.reposiroty;

import hello.jwtpractice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Boolean existsByEmail(String username);

    UserEntity findByEmail(String username);


}
