package com.paris.jo.services;

import com.paris.jo.dtos.UserDTO;
import com.paris.jo.entities.AppUser;
import com.paris.jo.exceptions.UserNotFoundException;
import com.paris.jo.mappers.UserMapperImpl;
import com.paris.jo.repositories.UserRepository;
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
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapperImpl dtoMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        log.info("Saving new User");
        AppUser user=dtoMapper.fromUserDTO(userDTO);
        AppUser savedUser = userRepository.save(user);
        return dtoMapper.fromUser(savedUser);
    }

    @Override
    public UserDTO getUser(Long userId) throws UserNotFoundException {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not found"));
        return dtoMapper.fromUser(user);    }

    @Override
    public List<UserDTO> listUsers() {
        List<AppUser> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(user -> dtoMapper.fromUser(user))
                .collect(Collectors.toList());

        return  userDTOS;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        log.info("Saving new User");
        AppUser user=dtoMapper.fromUserDTO(userDTO);
        AppUser savedUser = userRepository.save(user);
        return dtoMapper.fromUser(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDTO> searchUsers(String keyword) {
        List<AppUser> users=userRepository.searchUser(keyword);
        List<UserDTO> userDTOS = users.stream().map(user -> dtoMapper.fromUser(user)).collect(Collectors.toList());
        return userDTOS;
    }
}

