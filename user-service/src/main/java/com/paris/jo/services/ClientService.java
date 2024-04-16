package com.paris.jo.services;

import com.paris.jo.dtos.ClientDTO;
import com.paris.jo.exceptions.ClientNotFoundException;

import java.util.List;
public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);

    ClientDTO getClient(Long clientId) throws ClientNotFoundException;

    List<ClientDTO> listClients();

    ClientDTO updateClient(ClientDTO clientDTO);

    void deleteClient(Long clientId);

    List<ClientDTO> searchClients(String keyword);
}
