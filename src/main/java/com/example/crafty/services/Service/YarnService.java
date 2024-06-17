package com.example.crafty.services.Service;

import com.example.crafty.dto.YarnDTOtoYarn;
import com.example.crafty.dto.YarnToDto;
import com.example.crafty.entities.Yarn;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface YarnService {
    List<Yarn> getAllYarns();
    YarnToDto findById(UUID id);
    YarnToDto addNewYarn(YarnDTOtoYarn yarnDTOtoYarn, MultipartFile image) throws IOException;
    List<YarnToDto>showAll();
    YarnToDto updateYarn(UUID id, YarnDTOtoYarn yarnDTOtoYarn);
    YarnToDto updateYarnPicture(UUID id, MultipartFile multipartFile) throws IOException;
    void deleteYarn(UUID id);



}
