package com.diploma.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(name = "name")
    @Getter
    @Setter
    private String name;


    // remaining getters and setters
}
