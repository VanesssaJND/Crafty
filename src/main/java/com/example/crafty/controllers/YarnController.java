package com.example.crafty.controllers;

import com.example.crafty.dto.YarnDTO;
import com.example.crafty.entities.Yarn;
import com.example.crafty.response.ResponseMessage;
import com.example.crafty.services.Service.YarnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor

@RestController
@RequestMapping("/api/yarn_stash")
public class YarnController {

    private YarnService yarnService;
    @PostMapping(value = "/new_yarn", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ResponseMessage> createNewYarn(@RequestPart("yarn" )YarnDTO yarnDTO,
                                                         @RequestPart("image") MultipartFile image) throws IOException{
        yarnService.addNewYarn(yarnDTO,image);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Articulo agregado exitosamente"));
    }
}
