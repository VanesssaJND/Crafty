package com.example.crafty.services.Service;

import com.example.crafty.entities.yarn.Yarn;

import java.util.List;
import java.util.UUID;

public interface YarnService {
    List<Yarn> getAllYarns();
    Yarn findById(UUID id);
    Yarn AddNewYarn(Yarn yarn);

}
