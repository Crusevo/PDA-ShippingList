package com.example.PDA.ShippingList.RestController;

import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.UserRepository;
import com.example.PDA.ShippingList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInPageController {

    @Autowired
    UserService userService;

    @GetMapping("/signInPage/")
    public String signInPage(Model model){
        model.addAttribute("user", new User());
        return "signInPage";
    }

    @PostMapping("/signInPage/")
    public String signInPagePost(@ModelAttribute User user, Model model){

        model.addAttribute("user",user);

       userService.saveUser(user);

        return "redirect:/successPage/";
    }


}
