package com.example.PDA.ShippingList.SpringSecurity;

import com.example.PDA.ShippingList.Model.Role;
import com.example.PDA.ShippingList.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    @Autowired
    User user;

    public MyUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> userRoles = user.getUserRoles();

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();

        for(Role role : userRoles){

            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role.getRoleName()));

        }

        return simpleGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public String getFirstName(){return  user.getFirstName();}
    public String getLastName(){return  user.getLastName();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
