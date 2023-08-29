package com.cp.sf.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "trtrtrt3")
public class User {

    @NonNull
    @Column(unique = true)
    private Long id;
    @NonNull
    private String loggedinuser;

    private String timezone;
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

    @CreatedDate
    @NonNull
    private Date createdate;
    @NonNull
    @LastModifiedDate
    private Date modifieddate;

    @CreatedBy
    @NonNull
    private String createdby;
    @NonNull
    @LastModifiedBy
    private String modifiedby;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    @NonNull
    private Address address;

    public User(@NonNull Long id, @NonNull String loggedinuser, @NonNull String username, @NonNull String password, @NonNull String mailid, @NonNull long mobileno, @NonNull Integer active,  @NonNull String createdby, @NonNull String modifiedby) {
        this.id = id;
        this.loggedinuser = loggedinuser;
        this.username = username;
        this.password = password;
        this.mailid = mailid;
        this.mobileno = mobileno;
        this.active = active;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
    }
}