package com.paris.jo.repositories;

import com.paris.jo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByLastName(String lastName);
    @Query("select c from Client c where c.lastName like :kw")
    List<Client> searchUser(@Param("kw") String keyword);
}
