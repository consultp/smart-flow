package com.cp.sf.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserTables")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String mailid;

}