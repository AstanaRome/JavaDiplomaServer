package com.diploma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "doctors")
public class Doctor extends BaseEntity {


    @Column(name = "qualification")
    @Getter
    @Setter
    private String qualification;
    @Column(name = "experience")
    @Getter
    @Setter
    private int experience;
  //  @NotNull
    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;





}
