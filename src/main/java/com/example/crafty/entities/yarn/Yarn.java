package com.example.crafty.entities.yarn;

import com.example.crafty.enums.ColorFamily;
import com.example.crafty.enums.FiberType;
import com.example.crafty.enums.YarnWeight;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Yarn {
    @Id
    @SequenceGenerator(
            name = "yarn_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "yarn_sequence"
    )
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    private String brand;
    @NotBlank
    @Column(nullable = false)
    private String color;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ColorFamily colorFamily;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FiberType fiberType;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private YarnWeight yarnWeight;
    @NotBlank
    @Column(nullable = false)
    private int quantity;
}
