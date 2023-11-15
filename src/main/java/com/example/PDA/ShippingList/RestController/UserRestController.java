package com.example.PDA.ShippingList.RestController;

import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping("/addUserToDataBase/")
    public void addUserToDataBase(@RequestBody User user) {
        userService.addUserToDataBase(user);
    }

    @GetMapping("/getUsers/")
    public void findAllUsers() {
        userService.findAllUsers();
    }


}

