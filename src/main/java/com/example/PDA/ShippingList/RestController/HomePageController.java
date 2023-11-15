package com.example.PDA.ShippingList.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/homePage/")
    public String getHome() {
        return "homePage";
    }

}
