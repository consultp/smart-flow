package com.cp.sf.Mapper;

import com.cp.sf.DTO.UserDto;
import com.cp.sf.Entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-09T14:45:57+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto usertodto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setLoggedinuserssssss( user.getLoggedinuser() );
        userDto.setId( user.getId() );
        userDto.setTimezone( user.getTimezone() );
        userDto.setUsername( user.getUsername() );
        userDto.setPassword( user.getPassword() );
        userDto.setMailid( user.getMailid() );
        userDto.setMobileno( user.getMobileno() );
        userDto.setActive( user.getActive() );
        userDto.setCreatedate( user.getCreatedate() );
        userDto.setModifieddate( user.getModifieddate() );
        userDto.setCreatedby( user.getCreatedby() );
        userDto.setModifiedby( user.getModifiedby() );
        userDto.setAddress( user.getAddress() );

        return userDto;
    }

    @Override
    public User userdtotouser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setTimezone( userDto.getTimezone() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setMailid( userDto.getMailid() );
        user.setMobileno( userDto.getMobileno() );
        user.setActive( userDto.getActive() );
        user.setCreatedate( userDto.getCreatedate() );
        user.setModifieddate( userDto.getModifieddate() );
        user.setCreatedby( userDto.getCreatedby() );
        user.setModifiedby( userDto.getModifiedby() );
        user.setAddress( userDto.getAddress() );

        return user;
    }
}
