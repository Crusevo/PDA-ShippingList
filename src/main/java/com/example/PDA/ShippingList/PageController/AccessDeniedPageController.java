package com.example.PDA.ShippingList.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedPageController {

    @GetMapping("/accessDeniedPage/")
    public String getAccessDeniedPage(){

        return "accessDeniedPage";
    }


}
