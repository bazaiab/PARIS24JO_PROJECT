package com.paris.jo.web;

import com.paris.jo.dtos.ClientDTO;
import com.paris.jo.exceptions.ClientNotFoundException;
import com.paris.jo.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ClientsController {

    private ClientService clientService;
    
    @GetMapping("/clients")
    public List<ClientDTO> clients(){
        return clientService.listClients();
    }
    
    @GetMapping("/clients/search")
    @PreAuthorize("hasAuthority('USER')")
    public List<ClientDTO> searchclients(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return clientService.searchClients("%"+keyword+"%");
    }
    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable(name = "id") Long userId) throws ClientNotFoundException {
        return clientService.getClient(userId);
    }
    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO UserDTO){
        return clientService.saveClient(UserDTO);
    }
    @PutMapping("/clients/{clientId}")
    public ClientDTO updateUser(@PathVariable Long ClientId, @RequestBody ClientDTO UserDTO){
        UserDTO.setId(ClientId);
        return clientService.updateClient(UserDTO);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/mySession")
    public Authentication authentication(Authentication auth) {
        return auth;
    }


    
}
