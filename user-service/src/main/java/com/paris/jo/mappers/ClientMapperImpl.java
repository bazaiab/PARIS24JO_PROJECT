package com.paris.jo.mappers;


import com.paris.jo.dtos.RoleDTO;
import com.paris.jo.dtos.ClientDTO;
import com.paris.jo.entities.Role;
import com.paris.jo.entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientMapperImpl {
    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return clientDTO;
    }
    public Client fromClientDTO(ClientDTO UserDTO){
        Client client=new Client();
        BeanUtils.copyProperties(UserDTO,client);
        return client;
    }

    public RoleDTO fromRole(Role role){
        RoleDTO roleDTO=new RoleDTO();
        BeanUtils.copyProperties(role,roleDTO);
        return roleDTO;
    }
    public Role fromRoleDTO(RoleDTO RoleDTO){
        Role role=new Role();
        BeanUtils.copyProperties(RoleDTO,role);
        return role;
    }


}
