package com.example.MavenLogin.service;


import com.example.MavenLogin.model.UserModel;
import com.example.MavenLogin.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserModel registerUser(String login, String password, String email){
        if (login == null || password == null) {

            return null;


        } else {
            if(usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return usersRepository.save(userModel);

        }


    }


    public UserModel authenticate(String login,String password){
        return  usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }

}
