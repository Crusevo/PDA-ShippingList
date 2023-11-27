package com.example.PDA.ShippingList.ModelController;

import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserRestController {

    @Autowired
    UserService userService;


    @GetMapping("/getUsers/")
    public void findAllUsers() {
        userService.findAllUsers();
    }


}

