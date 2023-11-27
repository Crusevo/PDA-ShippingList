package com.example.PDA.ShippingList.PageController;

import com.example.PDA.ShippingList.Model.Role;
import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.RoleRepository;
import com.example.PDA.ShippingList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class SignInPageController {

    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/signInPage/")
    public String getSignInPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleRepository.findAll());

        return "signInPage";
    }

    @PostMapping("/signInPage/")
    public String postSignInPage(@ModelAttribute("user") User user, @RequestParam("role") String roleName){


        Role byRoleName = roleRepository.findByRoleName(roleName);

        Set<Role> userRoles = user.getUserRoles();
        userRoles.add(byRoleName);

        userService.saveUser(user);

        return "redirect:/successPage/";
    }


}
