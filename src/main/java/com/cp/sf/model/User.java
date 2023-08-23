package com.cp.sf.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "UserTables28")
@NoArgsConstructor
@RequiredArgsConstructor
public class User {



    @NonNull

    @Column(unique = true)
    private Long id;

     @NonNull
     @Id
     @Column(unique = true)
    private String username;
    @NonNull
    private String password;
    @NonNull
    @Column(unique = true)
    private String mailid;
    @Column(unique = true)
    @NonNull
    private long mobileno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    @NonNull
    private Address address;

}