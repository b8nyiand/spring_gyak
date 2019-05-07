package hu.flowacademy.todolist.repository;

import hu.flowacademy.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {



}
