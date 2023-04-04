package com.diploma.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
}