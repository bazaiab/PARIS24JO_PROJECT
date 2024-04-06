package com.paris.jo.services;

import com.paris.jo.dtos.UserDTO;
import com.paris.jo.exceptions.UserNotFoundException;

import java.util.List;
public interface UserService {
    UserDTO saveUser(UserDTO userDTO);

    UserDTO getUser(Long userId) throws UserNotFoundException;

    List<UserDTO> listUsers();

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long userId);

    List<UserDTO> searchUsers(String keyword);
}
