package com.diploma.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class ValidationException extends Exception {

    @Getter
    private final List<Violation> violations;
}