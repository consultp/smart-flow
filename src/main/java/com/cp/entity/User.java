package com.cp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Userid;
     @Column(name="fname")
    private String Username;
     @Column(name="password")
      private String password;
     @Column(name="mobileno")
     private Long Mobileno;



}
