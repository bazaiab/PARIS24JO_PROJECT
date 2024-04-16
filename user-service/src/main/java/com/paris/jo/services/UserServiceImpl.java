package com.paris.jo.services;

import com.paris.jo.dtos.ClientDTO;
import com.paris.jo.entities.Client;
import com.paris.jo.exceptions.ClientNotFoundException;
import com.paris.jo.mappers.ClientMapperImpl;
import com.paris.jo.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    private ClientMapperImpl dtoMapper;

    @Override
    public ClientDTO saveClient(ClientDTO userDTO) {
        log.info("Saving new User");
        Client client = dtoMapper.fromClientDTO(userDTO);

        /*if (userDTO.getRole().getRole() != null && !userDTO.getRole().getRole().isEmpty()) {
            Role role = roleRepository.findByRole(userDTO.getRole().getRole());
            if (role != null) {
                user.setRoles(Arrays.asList(role));
            }
        }*/

        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClient(Long userId) throws ClientNotFoundException {
        Client user = clientRepository.findById(userId)
                .orElseThrow(() -> new ClientNotFoundException("User Not found"));
        return dtoMapper.fromClient(user);
    }

    @Override
    public List<ClientDTO> listClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = clients.stream()
                .map(user -> dtoMapper.fromClient(user))
                .collect(Collectors.toList());

        return clientDTOS;
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        log.info("Saving new Client");
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public List<ClientDTO> searchClients(String keyword) {
        List<Client> clients = clientRepository.searchUser(keyword);
        List<ClientDTO> clientDTOS = clients.stream().map(client -> dtoMapper.fromClient(client)).collect(Collectors.toList());
        return clientDTOS;
    }
}
