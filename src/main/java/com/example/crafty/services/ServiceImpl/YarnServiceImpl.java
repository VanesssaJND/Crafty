package com.example.crafty.services.ServiceImpl;

import com.example.crafty.dto.YarnDTOtoYarn;
import com.example.crafty.dto.YarnToDto;
import com.example.crafty.entities.Color;
import com.example.crafty.entities.Yarn;
import com.example.crafty.exceptions.YarnNotFoundException;
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

    public YarnToDto findById(UUID id){
        Optional<Yarn> answer = yarnRepository.findById(id);

        if(answer.isPresent()) {
            Yarn yarn = answer.get();
            return YarnToDto.fromEntity(yarn);
        }
        throw new YarnNotFoundException(id);
    }
    @Override
    public YarnToDto addNewYarn(YarnDTOtoYarn yarnDTOtoYarn, MultipartFile image) throws IOException {
        Yarn yarn = yarnDTOtoYarn.toEntity();
        if(image==null){
            yarn.setImage("https://res.cloudinary.com/ddn3lbfuv/image/upload/v1718830118/lana_p2311f.webp");
        }else {
            String imageUrl = cloudinaryService.uploadImage(image);
            yarn.setImage(imageUrl);
        }
        yarnRepository.save(yarn);
        return YarnToDto.fromEntity(yarn);
    }

    @Override
    public List<YarnToDto> showAll() {
        List<Yarn> yarns = yarnRepository.findAll();
        return YarnToDto.fromYarnList(yarns);
    }

    @Override
    public YarnToDto updateYarn(UUID id, YarnDTOtoYarn yarnDTOtoYarn) {
        Optional<Yarn> answer = yarnRepository.findById(id);
        if(answer.isPresent()){
            Yarn yarn = answer.get();
            yarn.setName(yarnDTOtoYarn.name());
            yarn.setBrand(yarnDTOtoYarn.brand());
            yarn.setColorFamily(yarnDTOtoYarn.colorFamily());
            yarn.setColor(new Color(yarnDTOtoYarn.colorName(), yarnDTOtoYarn.colorHexCode()));
            yarn.setFiberType(yarnDTOtoYarn.fiberType());
            yarn.setYarnWeight(yarnDTOtoYarn.yarnWeight());
            yarn.setQuantity(yarnDTOtoYarn.quantity());

            yarnRepository.save(yarn);
            return YarnToDto.fromEntity(yarn);
        }
        throw new YarnNotFoundException(id);
    }

    @Override
    public YarnToDto updateYarnPicture(UUID id, MultipartFile image) throws IOException {
        Optional<Yarn> answer = yarnRepository.findById(id);
        if (answer.isPresent()) {
            Yarn yarn = answer.get();
            String imageUrl = cloudinaryService.uploadImage(image);
            yarn.setImage(imageUrl);
            return YarnToDto.fromEntity(yarn);
        }else {
            throw new YarnNotFoundException(id);
        }
    }

    @Override
    public void deleteYarn(UUID id) {
        Yarn yarn = yarnRepository.findById(id).orElseThrow(() -> new YarnNotFoundException(id));
        yarnRepository.deleteById(id);
    }
}
