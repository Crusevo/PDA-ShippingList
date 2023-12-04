package com.example.PDA.ShippingList.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddItemToProjectController {

    @GetMapping("/addItemToProject/")
    public String getAddItemToProject(@RequestParam Long projectId, @RequestParam String projectNumber, Model model){
        model.addAttribute("projectId", projectId);
        model.addAttribute("projectNumber", projectNumber);
        return "addItemToProject";
    }



}
