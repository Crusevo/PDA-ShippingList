package com.example.PDA.ShippingList.Service;

import com.example.PDA.ShippingList.Model.Role;
import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean registerOk;


    public void findAllUsers() {
        userRepository.findAll();
    }

    public void saveUser(User user){

        if(userRepository.findByEmail(user.getEmail()).isEmpty()){

                String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);

                Set<Role> userRoles = user.getUserRoles();

                userRepository.saveAndFlush(user);

                registerOk = true;


            }else {

            System.out.println("User already exist!");

            registerOk = false;


        }


    }
}
