package com.paris.jo.clients;

import com.paris.jo.models.Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping("/clients/{id}")
    @CircuitBreaker(name = "userService", fallbackMethod = "getDefaultClient")
    Client findClientById(@PathVariable Long id);

    @GetMapping("/clients")
    @CircuitBreaker(name = "clientService", fallbackMethod = "getDefaultAllClients")
    List<Client> getAllClients();

    default Client getDefaultClient(Long id, Exception exception) {
        return Client.builder()
                .id(id)
                .lastName("Not Available")
                .firstName("Not Available")
                .email("Not Available")
                .build();
    }
    default List<Client> getDefaultAllClients(Exception exception) {
        return List.of();
    }
}
