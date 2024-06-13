package com.example.crafty.dto;

import com.example.crafty.entities.Color;
import com.example.crafty.entities.Yarn;
import com.example.crafty.enums.ColorFamily;
import com.example.crafty.enums.FiberType;
import com.example.crafty.enums.YarnWeight;

public record YarnToDto(
        String name,
        String brand,
        String colorName,
        String colorHexCode,
        ColorFamily colorFamily,
        FiberType fiberType,
        YarnWeight yarnWeight,
        Integer quantity,
        String image
) {
    public static YarnToDto fromEntity(Yarn yarn) {
        return new YarnToDto(
                yarn.getName(),
                yarn.getBrand(),
                yarn.getColor().getName(),
                yarn.getColor().getHexCode(),
                yarn.getColorFamily(),
                yarn.getFiberType(),
                yarn.getYarnWeight(),
                yarn.getQuantity(),
                yarn.getImage()
        );
    }
}