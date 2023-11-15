package com.example.PDA.ShippingList.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/loginPage/")
    public String loginPage(){
        return "loginPage";
    }


}



