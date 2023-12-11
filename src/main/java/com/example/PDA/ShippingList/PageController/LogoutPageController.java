package com.example.PDA.ShippingList.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutPageController {

    @GetMapping("/logoutPage/")
    public String getLogoutPage(){

        return "logoutPage";

    }


}
