package com.example.PDA.ShippingList.PageController;

import com.example.PDA.ShippingList.Model.Project;
import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.ProjectRepository;
import com.example.PDA.ShippingList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProjectPageController{

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;



    @GetMapping("/projectPage/")
    public String getProjectPage(Model model)  {

        List<Project> allProjects = projectRepository.findAll();
        List<User> allUsers = userRepository.findAll();


        model.addAttribute("project", new Project());
        model.addAttribute("allProjects", allProjects);

        return "projectPage";
    }

    @PostMapping("/projectPage/")
    public String postProjectPage(@ModelAttribute("project") Project project){

        projectRepository.saveAndFlush(project);

        return "redirect:/projectPage/";
    }


}
