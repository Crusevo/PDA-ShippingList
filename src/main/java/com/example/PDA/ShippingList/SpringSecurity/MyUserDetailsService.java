package com.example.PDA.ShippingList.SpringSecurity;

import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<User> byUserName = userRepository.findByEmail(email);

        if(byUserName.isEmpty()) throw new UsernameNotFoundException("Nie znaleziono użytkownika o tej nazwie");

        return new MyUserDetails(byUserName.get(0));
    }
}
