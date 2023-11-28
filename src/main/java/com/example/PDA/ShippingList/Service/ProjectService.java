package com.example.PDA.ShippingList.Service;

import com.example.PDA.ShippingList.Model.Project;
import com.example.PDA.ShippingList.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public void saveProject(Project project){

       if(projectRepository.findByProjectNumber(project.getProjectNumber()).isEmpty()){
           projectRepository.save(project);
       }else {
           System.out.println("Project already exist");
       }

    }



}
