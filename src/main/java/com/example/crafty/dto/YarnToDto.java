package com.example.crafty.dto;

import com.example.crafty.entities.Yarn;
import com.example.crafty.enums.ColorFamily;
import com.example.crafty.enums.FiberType;
import com.example.crafty.enums.YarnWeight;

import java.util.ArrayList;
import java.util.List;

public record YarnToDto(
        java.util.UUID id,
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
                yarn.getId(),
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

    public static List<YarnToDto> fromYarnList(List<Yarn> yarnList) {
        List<YarnToDto> dtoList = new ArrayList<>();
        for (Yarn yarn : yarnList) {
            dtoList.add(fromEntity(yarn));
        }
        return dtoList;
    }
}