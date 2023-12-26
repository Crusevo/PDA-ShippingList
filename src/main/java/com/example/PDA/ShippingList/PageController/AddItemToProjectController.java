package com.example.PDA.ShippingList.PageController;

import com.example.PDA.ShippingList.Model.Item;
import com.example.PDA.ShippingList.Model.Project;
import com.example.PDA.ShippingList.Repository.ItemRepository;
import com.example.PDA.ShippingList.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"selectedProject","projectId","projectNumber"})
public class AddItemToProjectController {


    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ItemRepository itemRepository;


    @GetMapping("/addItemToProject/")
    public String getAddItemToProject(@RequestParam Long projectId, @RequestParam String projectNumber, Model model){

        model.addAttribute("item", new Item());
        model.addAttribute("projectId", projectId);
        model.addAttribute("projectNumber", projectNumber);

        Project selectedProject = projectRepository.findById(projectId).orElseThrow();
        model.addAttribute("selectedProject",selectedProject);
        List<Item> itemList = selectedProject.getItemList();
        model.addAttribute("itemList", itemList);

        return "addItemToProject";
    }


    @PostMapping("/addItemToProject/")
    public String postAddItemToProject(@ModelAttribute("item") Item item, Model model){

        Project selectedProject = (Project) model.getAttribute("selectedProject");
        Long projectId = (Long) model.getAttribute("projectId");
        String projectNumber = (String) model.getAttribute("projectNumber");



        selectedProject.getItemList().add(item);

        projectRepository.save(selectedProject);

        itemRepository.save(item);

        return "redirect:/addItemToProject/?projectId=" + projectId + "&projectNumber=" + projectNumber;



    }



}
