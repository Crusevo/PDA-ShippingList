package com.example.PDA.ShippingList.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessPageController {

    @GetMapping("/successPage/")
    public String successPage(){
        return "successPage";
    }

}
