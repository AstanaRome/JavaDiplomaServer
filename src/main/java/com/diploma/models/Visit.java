package com.diploma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "record_day")
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private LocalDate record_day;


    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Getter
    @Setter
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "record_id")
    private Record record;

    @Getter
    @Setter
    @Column(name = "result")
    private String result;

}
