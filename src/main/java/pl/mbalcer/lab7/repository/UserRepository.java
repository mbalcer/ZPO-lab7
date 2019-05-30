package pl.mbalcer.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mbalcer.lab7.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}