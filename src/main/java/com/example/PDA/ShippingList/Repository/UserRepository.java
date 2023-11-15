package com.example.PDA.ShippingList.Repository;

import com.example.PDA.ShippingList.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query
    List<User> findByEmail(String email);


}
