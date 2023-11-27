package com.example.PDA.ShippingList.Repository;

import com.example.PDA.ShippingList.Model.Item;
import com.example.PDA.ShippingList.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {


}
