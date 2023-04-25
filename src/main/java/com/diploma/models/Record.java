package com.diploma.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "records")
public class Record extends BaseEntity {

    @Column(name = "record_day")
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private LocalDate record_day;
    @Column(name = "record_time")
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone="CET")
    private LocalTime record_time;

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





}
