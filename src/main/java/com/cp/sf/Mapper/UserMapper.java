package com.cp.sf.Mapper;

import com.cp.sf.DTO.UserDto;
import com.cp.sf.Entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.xml.transform.Source;

@Mapper
public interface UserMapper {
   UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
   @Mapping(source = "user.loggedinuser",target = "loggedinuserssssss")
   @InheritInverseConfiguration
    UserDto usertodto(User user);
    User    userdtotouser(UserDto userDto);

    }




