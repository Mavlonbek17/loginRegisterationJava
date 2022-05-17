package com.example.MavenLogin.repository;

import com.example.MavenLogin.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserModel,Integer> {

    Optional<UserModel> findByLoginAndPassword(String login,String Password);
    Optional<UserModel> findFirstByLogin(String login);

}
