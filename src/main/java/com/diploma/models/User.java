package com.diploma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.persistence.*;
import javax.validation.Constraint;


import javax.validation.constraints.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
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

//    @NotNull
//    @NotBlank
//    @NotEmpty
    @Column(name = "username", unique = true)
    @Getter
    @Setter
    private String username;

//    @Size(min = 10, max = 200, message
//            = "Password not lesser 6 symbols")
//    @Column(name = "password")
    @Getter
    @Setter
    private String password;



    @Column(name = "email", unique = true)
    @Getter
    @Setter
  //  @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
  //  @NotEmpty(message = "Email cannot be empty")
    private String email;

//    @NotNull
//    @NotBlank
//    @NotEmpty
    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

//    @NotNull
//    @NotBlank
//    @NotEmpty
    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;


    @Column(name = "birthdate")
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private LocalDate birthDate;

  //  @NotNull
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
