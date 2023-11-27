package com.example.PDA.ShippingList.Repository;

import com.example.PDA.ShippingList.Model.Item;
import com.example.PDA.ShippingList.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {



}
