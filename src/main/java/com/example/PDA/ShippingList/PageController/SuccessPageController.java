package com.example.PDA.ShippingList.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessPageController {

    @GetMapping("/successPage/")
    public String getSuccessPage(){
        return "successPage";
    }

}
