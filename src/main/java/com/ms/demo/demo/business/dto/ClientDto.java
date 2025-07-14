package com.ms.demo.demo.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClientDto {
    @NotEmpty(message = "firstname is required")
    private String firstname;
    @NotEmpty(message = "lastname is required")
    private String lastname;
    @NotNull(message = "age is required")
    @Positive(message = "age has to be a positive number")
    private Integer age;
    @NotNull(message = "birthday is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
}
