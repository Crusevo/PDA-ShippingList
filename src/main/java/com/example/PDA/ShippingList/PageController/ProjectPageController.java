package com.example.PDA.ShippingList.PageController;

import com.example.PDA.ShippingList.Model.Project;
import com.example.PDA.ShippingList.Model.User;
import com.example.PDA.ShippingList.Repository.ProjectRepository;
import com.example.PDA.ShippingList.Repository.UserRepository;
import com.example.PDA.ShippingList.Service.ProjectService;
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

    @Autowired
    ProjectService projectService;



    @GetMapping("/projectPage/")
    public String getProjectPage(Model model)  {

        List<Project> allProjects = projectRepository.findAll();
        List<User> allUsers = userRepository.findAll();


        model.addAttribute("project", new Project());
        model.addAttribute("allProjects", allProjects);
        model.addAttribute("allUsers", allUsers);

        return "projectPage";
    }

    @PostMapping("/projectPage/")
    public String postProjectPage(@ModelAttribute("project") Project project){

        projectService.saveProject(project);

        return "redirect:/projectPage/";
    }

    @PostMapping("/addUserToProject/")
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



        return "redirect:/projectPage/";
    }


}
