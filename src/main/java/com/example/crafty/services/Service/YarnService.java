package com.example.crafty.services.Service;

import com.example.crafty.dto.YarnDTO;
import com.example.crafty.entities.Yarn;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface YarnService {
    List<Yarn> getAllYarns();
    Yarn findById(UUID id);
    void addNewYarn(YarnDTO yarnDTO, MultipartFile image) throws IOException;

}
