package com.example.PDA.ShippingList.Service;

import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUserToDataBase(User user){
        userRepository.saveAndFlush(user);
    }


    public void findAllUsers() {
        userRepository.findAll();
    }

    public void saveUser(User user) {

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.saveAndFlush(user);

    }
}
