package com.diploma.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

public class UserForm {


    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private String changeColumn;



}