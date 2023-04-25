package com.diploma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username")
    @Getter
    @Setter
    private String username;
    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "birthdate")
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private LocalDate birthDate;

    @Column(name = "enabled")
    @Getter
    @Setter
    private boolean enabled;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Getter
//    @Setter
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
    @Getter
    @Setter
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "role_id")
    private Role role_id;





}
