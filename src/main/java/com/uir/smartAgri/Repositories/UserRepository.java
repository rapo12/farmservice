package com.uir.smartAgri.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uir.smartAgri.Entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
