package com.example.crafty.controllers;

import com.example.crafty.dto.YarnDTOtoYarn;
import com.example.crafty.dto.YarnToDto;
import com.example.crafty.services.Service.YarnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor

@RestController
@RequestMapping("/api/yarn_stash")
public class YarnController {

    private YarnService yarnService;
    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }
    @PostMapping(value = "/new_yarn", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<YarnToDto> createNewYarn(@RequestPart("yarn" ) YarnDTOtoYarn yarnDTOtoYarn,
                                                         @RequestPart("image") MultipartFile image) throws IOException{
        YarnToDto yarntoDTO =yarnService.addNewYarn(yarnDTOtoYarn,image);
        return ResponseEntity.status(HttpStatus.CREATED).body(yarntoDTO);
    }

    @GetMapping
    public ResponseEntity<List<YarnToDto>>findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(yarnService.showAll());
    }

    @GetMapping("/yarn/{id}")
    public ResponseEntity<YarnToDto> findById (@PathVariable UUID id){
        YarnToDto yarnToDto = yarnService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(yarnToDto);
    }

    @PatchMapping("/modify_yarn_picture/{id}")
    public ResponseEntity<YarnToDto>modifyPicture(@PathVariable UUID id, MultipartFile multipartFile) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(yarnService.updateYarnPicture(id, multipartFile));
    }

    @PutMapping("modify_yarn/{id}")
    public ResponseEntity<YarnToDto>modifyYarn(@PathVariable UUID id, @RequestBody YarnDTOtoYarn yarnDTOtoYarn ){
        return ResponseEntity.status(HttpStatus.OK).body(yarnService.updateYarn(id, yarnDTOtoYarn));
    }

    @DeleteMapping("delete_yarn/{id}")
    public ResponseEntity<?> deleteYarn(@PathVariable UUID id) {
            yarnService.deleteYarn(id);
            return ResponseEntity.noContent().build();
    }
}
