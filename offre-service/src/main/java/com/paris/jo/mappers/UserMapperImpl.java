package com.paris.jo.mappers;


import com.paris.jo.dtos.UserDTO;
import com.paris.jo.entities.AppUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl {
    public UserDTO fromUser(AppUser user){
        UserDTO UserDTO=new UserDTO();
        BeanUtils.copyProperties(user,UserDTO);
        return UserDTO;
    }
    public AppUser fromUserDTO(UserDTO UserDTO){
        AppUser user=new AppUser();
        BeanUtils.copyProperties(UserDTO,user);
        return user;
    }


}
