package com.example.crafty.services.ServiceImpl;

import com.example.crafty.dto.YarnDTOtoYarn;
import com.example.crafty.dto.YarnToDto;
import com.example.crafty.entities.Yarn;
import com.example.crafty.exceptions.ResourceNotFoundException;
import com.example.crafty.repositories.YarnRepository;
import com.example.crafty.services.Service.YarnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class YarnServiceImpl implements YarnService {

    private final YarnRepository yarnRepository;
    private final CloudinaryService cloudinaryService;

    public List<Yarn> getAllYarns(){
        return yarnRepository.findAll();
    }

    //Todo implementar la logica para el caso donde la respuesta sea null
    public YarnToDto findById(UUID id) throws ResourceNotFoundException {
        Optional<Yarn> answer = yarnRepository.findById(id);

        if(answer.isPresent()) {
            Yarn yarn = answer.get();
            return YarnToDto.fromEntity(yarn);
        }
        throw new ResourceNotFoundException("Yarn with id " + id + " doesn't exist");
    }
    @Override
    //Todo Manejar adecuadamente las excepciones
    public YarnToDto addNewYarn(YarnDTOtoYarn yarnDTOtoYarn, MultipartFile image) throws IOException {
        Yarn yarn = yarnDTOtoYarn.toEntity();
        String imageUrl = cloudinaryService.uploadImage(image);
        yarn.setImage(imageUrl);
        yarnRepository.save(yarn);
        return YarnToDto.fromEntity(yarn);
    }
}
