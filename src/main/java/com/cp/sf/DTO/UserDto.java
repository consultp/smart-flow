package com.cp.sf.DTO;

import com.cp.sf.Entity.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String loggedinuserssssss;

    private String timezone;
    @Id
    private String username;
    private String password;
    private String mailid;
    private long mobileno;
    private Integer active;


    private Date createdate;

    private Date modifieddate;

    private String createdby;

    private String modifiedby;


    private Address address;
}
