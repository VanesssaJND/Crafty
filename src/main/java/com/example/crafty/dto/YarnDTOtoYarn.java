package com.example.crafty.dto;

import com.example.crafty.entities.Color;
import com.example.crafty.entities.Yarn;
import com.example.crafty.enums.ColorFamily;
import com.example.crafty.enums.FiberType;
import com.example.crafty.enums.YarnWeight;

public record YarnDTOtoYarn(
        String name,
        String brand,
        String colorName,
        String colorHexCode,
        ColorFamily colorFamily,
        FiberType fiberType,
        YarnWeight yarnWeight,
        Integer quantity
) {
    public Yarn toEntity() {
        return Yarn.builder()
                .name(this.name())
                .brand(this.brand())
                .color(new Color(this.colorName(), this.colorHexCode()))
                .colorFamily(this.colorFamily())
                .fiberType(this.fiberType())
                .yarnWeight(this.yarnWeight())
                .quantity(this.quantity())
                .build();
    }
}