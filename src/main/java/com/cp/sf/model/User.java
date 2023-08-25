package com.cp.sf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
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
    @NonNull
    private Integer active;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    @NonNull
    private Address address;

}