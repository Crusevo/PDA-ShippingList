package com.example.PDA.ShippingList.PageController;


import com.example.PDA.ShippingList.Model.Project;
import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.ProjectRepository;
import com.example.PDA.ShippingList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddUserToProjectPageController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/addUserToProjectPage/")
    public String getAddUserToProject( Model model){

        List<User> allUsers = userRepository.findAll();
        List<Project> allProjects = projectRepository.findAll();

        model.addAttribute("allUsers", allUsers);
        model.addAttribute("allProjects", allProjects);


        return "addUserToProject";
    }

    @PostMapping("/addUserToProjectPage/")
    public String postAddUserToProject(@RequestParam Long userId, @RequestParam Long projectId) {

        User user = userRepository.findById(userId).orElse(null);
        Project project = projectRepository.findById(projectId).orElse(null);

        try {

                user.getProjectsList().add(project);
                userRepository.save(user);
                project.setUser(user);
                projectRepository.save(project);


        }catch (StackOverflowError e){
            System.out.println("This user is already assigned to this project");
        }



        return "redirect:/addUserToProjectPage/";
    }


}
