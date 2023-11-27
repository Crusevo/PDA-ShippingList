package com.example.PDA.ShippingList.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    private int projectNumber;

    @ManyToOne()
    @JoinTable(name = "User_Projects", joinColumns = @JoinColumn(name = "Project_Id"),
            inverseJoinColumns = @JoinColumn(name = "User_Id"))
    private User user;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "Project_Item", joinColumns = @JoinColumn(name = "Project_Id"),
            inverseJoinColumns = @JoinColumn(name = "Item_Id"))
    private List<Item> itemList;



}
