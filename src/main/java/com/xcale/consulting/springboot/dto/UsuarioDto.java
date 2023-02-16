package com.xcale.consulting.springboot.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xcale.consulting.springboot.jackson.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String id;

    @JsonSerialize(using= LocalDateTimeSerializer.class)
    private LocalDateTime created;
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    private LocalDateTime modified;

    @JsonSerialize(using= LocalDateTimeSerializer.class)
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;

}
