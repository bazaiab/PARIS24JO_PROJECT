package com.paris.jo.web;

import com.paris.jo.dtos.UserDTO;
import com.paris.jo.exceptions.UserNotFoundException;
import com.paris.jo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class UsersController {

    private UserService userService;
    
    @GetMapping("/users")
    public List<UserDTO> users(){
        return userService.listUsers();
    }
    
    @GetMapping("/users/search")
    public List<UserDTO> searchUsers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return userService.searchUsers("%"+keyword+"%");
    }
    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long UserId) throws UserNotFoundException {
        return userService.getUser(UserId);
    }
    @PostMapping("/users")
    public UserDTO saveUser(@RequestBody UserDTO UserDTO){
        return userService.saveUser(UserDTO);
    }
    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable Long UserId, @RequestBody UserDTO UserDTO){
        UserDTO.setId(UserId);
        return userService.updateUser(UserDTO);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


    
}
