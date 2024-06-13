package com.example.crafty.controllers;

import com.example.crafty.dto.YarnDTOtoYarn;
import com.example.crafty.dto.YarnToDto;
import com.example.crafty.response.ResponseMessage;
import com.example.crafty.services.Service.YarnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor

@RestController
@RequestMapping("/api/yarn_stash")
public class YarnController {

    private YarnService yarnService;
    @PostMapping(value = "/new_yarn", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ResponseMessage> createNewYarn(@RequestPart("yarn" ) YarnDTOtoYarn yarnDTOtoYarn,
                                                         @RequestPart("image") MultipartFile image) throws IOException{
        yarnService.addNewYarn(yarnDTOtoYarn,image);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Articulo agregado exitosamente"));
    }

    @GetMapping("/yarn/{id}")
    public ResponseEntity<YarnToDto> findById (@PathVariable UUID id){
        YarnToDto yarnToDto = yarnService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(yarnToDto);
    }
}
