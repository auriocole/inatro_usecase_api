package api.inatro.inatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import api.inatro.inatro.model.user.user;


@Repository
public interface userRepository extends JpaRepository<user, Long> {
    UserDetails findByBi(String bi);
} 
