package com.paris.jo.repositories;

import com.paris.jo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser,Long> {
     AppUser findByName(String name);

    @Query("select u from AppUser u where u.name like :kw")
    List<AppUser> searchUser(@Param("kw") String keyword);
}
