package com.example.crafty.entities.yarn;

import com.example.crafty.enums.ColorFamily;
import com.example.crafty.enums.FiberType;
import com.example.crafty.enums.YarnWeight;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="yarn")
public class Yarn {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)

    private String name;

    private String brand;

    @NotBlank
    @Column(nullable = false)
    @Embedded
    @AttributeOverride( name = "name", column = @Column(name = "color_name"))
    private Color color;

    @Enumerated(EnumType.STRING)
    private ColorFamily colorFamily;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private FiberType fiberType;

    @Enumerated(EnumType.STRING)
    private YarnWeight yarnWeight;

    @NotBlank
    @Column(nullable = false)
    private int quantity;

    private String image;
}
