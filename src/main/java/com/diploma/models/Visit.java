package com.diploma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "visits")
public class Visit extends BaseEntity {
    @NotNull
    @Column(name = "record_day")
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private LocalDate record_day;

    @NotNull
    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
  //  @NotNull
    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
 //   @NotNull
    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "record_id")
    private Record record;

   // @NotBlank
  //  @NotEmpty
  //  @NotNull
    @Getter
    @Setter
    @Column(name = "result")
    private String result;

}
