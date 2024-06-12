package com.example.crafty.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Color {
    @NotBlank
    private String name;

    @NotBlank
    private String hexCode;
}
