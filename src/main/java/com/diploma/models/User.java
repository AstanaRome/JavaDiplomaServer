package com.diploma.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    private int user_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String email;
    @Column
    private String password;

    @Column
    private Date created_at;
    @Transient
    @Column
    private Date updated_at;




}
