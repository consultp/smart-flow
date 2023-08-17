package com.cp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     @Column(name="fname")
    private String firstname;
      @Column(name="lname")
    private String lastname;
      @Column(name="password")
      private String password;

}
