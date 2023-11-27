package com.example.PDA.ShippingList.PageController;

import com.example.PDA.ShippingList.Model.Project;
import com.example.PDA.ShippingList.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserPageController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/userPage/")
    public String getUserPage(Model model){

        List<Project> allProjects = projectRepository.findAll();
        model.addAttribute("allProjects", allProjects);
        return "userPage";
    }

}
